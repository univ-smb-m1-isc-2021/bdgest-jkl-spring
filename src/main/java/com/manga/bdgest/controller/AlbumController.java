package com.manga.bdgest.controller;

import com.manga.bdgest.model.Album;
import com.manga.bdgest.service.AlbumService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AlbumController {

    private final AlbumService albumService;

    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }


    @GetMapping(value = "/album/all")
    public List<Album> facts() {
        return albumService.getAll();
    }
}
