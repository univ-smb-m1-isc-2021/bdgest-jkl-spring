package com.manga.bdgest.controller;


import com.manga.bdgest.model.Album;
import com.manga.bdgest.model.Serie;
import com.manga.bdgest.service.AlbumService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/album")
public class AlbumController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private final AlbumService albumService;

    public AlbumController(AlbumService albumService){
        this.albumService = albumService;
    }

    @CrossOrigin
    @GetMapping(value = "/{id}")
    public Optional<Album> getAlbumById(@PathVariable(value="id") Long id){
        logger.info("Get album by id");
        return albumService.getById(id);
    }

    @CrossOrigin
    @GetMapping(value = "/{id}/serie")
    public Serie getSerieByAlbumId(@PathVariable(value="id") Long id){
        logger.info("Get serie by album id");
        return albumService.getById(id).get().getSerie();
    }

    @CrossOrigin
    @GetMapping(value = "/all")
    public List<Album> getAll(){
        logger.info("Get all albums");
        return albumService.getAll();
    }

}
