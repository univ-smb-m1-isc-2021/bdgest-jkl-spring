package com.manga.bdgest.model;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AlbumController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private final AlbumService albumService;

    public AlbumController(AlbumService albumService){
        this.albumService = albumService;
    }

    @GetMapping(value = "/album/")
    public List<Album> getAlbum(){
        logger.info("Serving album");
        return albumService.getAll();
    }
}
