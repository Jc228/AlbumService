package com.distribuida.rest.restcontrollers;


import com.distribuida.rest.entidades.Album;
import com.distribuida.rest.impl.AlbumDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/album")
public class AlbumController {
    @Autowired
    private AlbumDaoImpl albumDao;

    @RequestMapping(value = "/listar", method = RequestMethod.GET )
    public List<Album> listar(){
        return albumDao.listar();
    }

    @RequestMapping(value = "/buscar/{id}", method = RequestMethod.GET)
    public Album buscarAlbum(@PathVariable ("id") Long id){
        return albumDao.findById(id);
    }

    @RequestMapping(value = "/actualizar/{id}" , method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE )
    public Album actualizarAlbum(@PathVariable ("id") Long id, @RequestBody Album actAlbum){
        Album album = albumDao.findById(id);
        album.setTitle(actAlbum.getTitle());
        album.setReleaseDate(actAlbum.getReleaseDate());
        album.setSinger_id(actAlbum.getSinger_id());
        Album act = albumDao.updateAlbum(album);
        return act;
    }

    @RequestMapping(value = "/crear", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Album crearAlbum(@Valid @RequestBody Album album){
        return albumDao.addAlbum(album); }

    @RequestMapping(value = "/eliminar/{id}",method = RequestMethod.DELETE)
    public boolean eliminarAlbum(@PathVariable Long id){
        boolean eliminar = false;
        Album eliminarAlb = albumDao.findById(id);
        if (eliminarAlb!=null){
            albumDao.deleteAlbum(eliminarAlb);
            eliminar = true;
        }else{
            eliminar = false;
        }
        return eliminar;
    }
}
