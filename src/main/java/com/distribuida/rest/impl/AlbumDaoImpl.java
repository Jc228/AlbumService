package com.distribuida.rest.impl;

import com.distribuida.rest.entidades.Album;
import com.distribuida.rest.interfaces.AlbumDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

@Repository
public class AlbumDaoImpl implements AlbumDao {
    private final String LISTAR = "SELECT * FROM ALBUM";
    private final String BUSCAR_POR_ID = "SELECT * FROM ALBUM WHERE id=?";
    private final String INSERTAR = "INSERT INTO ALBUM (TITLE,RELEASE_DATE,SINGER_ID) values (?,?,?)";
    private final String UPDATE = "UPDATE ALBUM SET TITLE=?,RELEASE_DATE=?,SINGER_ID=? WHERE id=?";
    private final String DELETE = "DELETE FROM ALBUM WHERE id=?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Album> listar ( ) {
        return jdbcTemplate.query(LISTAR, new AlbumMapper());
    }

    @Override
    public Album findById (Long id) {
        return jdbcTemplate.queryForObject(BUSCAR_POR_ID, new Object[]{id}, new AlbumMapper());
    }

    @Override
    public Album addAlbum (Album album) {
        Object[] datos = new Object[] { album.getTitle(), album.getReleaseDate(),album.getSinger_id()};
        int[] tipos = new int[]{Types.VARCHAR, Types.DATE, Types.INTEGER};
        int registro = jdbcTemplate.update(INSERTAR,datos,tipos);
        System.out.println("Se inserto: "+album.getTitle()+" - "+album.getReleaseDate()+" - "+album.getSinger_id());
        return album;
    }

    @Override
    public Album updateAlbum (Album album) {
        Object[] datos = new Object[] { album.getTitle(), album.getReleaseDate(),album.getSinger_id(),album.getId()};
        int[] tipos = new int[]{Types.VARCHAR, Types.DATE, Types.INTEGER, Types.INTEGER};
        int registro = jdbcTemplate.update(UPDATE,datos,tipos);
        System.out.println("Se actualizo: "+album.getTitle()+" - "+album.getReleaseDate()+" - "+album.getSinger_id());
        return album;
    }

    @Override
    public Integer deleteAlbum (Album album) {
        Long id = album.getId();
        return jdbcTemplate.update(DELETE, new Object[]{Long.valueOf(id)});
    }
}
class AlbumMapper implements RowMapper<Album> {

    @Override
    public Album mapRow (ResultSet rs, int rowNum) throws SQLException {
        Album album = new Album();
        album.setId(rs.getLong("id"));
        album.setTitle(rs.getString("title"));
        album.setReleaseDate(rs.getDate("release_date"));
        album.setSinger_id(rs.getLong("singer_id"));
        album.setVersion(rs.getInt("version"));
        return album;
    }
}