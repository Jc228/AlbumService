package com.distribuida.rest.interfaces;

import com.distribuida.rest.entidades.Album;

import java.util.List;

public interface AlbumDao {
    public List<Album> listar();
    public Album findById(Long id);
    public Album addAlbum(Album album);
    public Album updateAlbum(Album album);
    public Integer deleteAlbum(Album album);
}
