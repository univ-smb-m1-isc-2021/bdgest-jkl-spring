package com.manga.bdgest.controller;


import com.manga.bdgest.model.Serie;
import com.manga.bdgest.service.SerieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/serie")
public class SerieController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());
    private final SerieService serieService;

    public SerieController(SerieService serieService){
        this.serieService = serieService;
    }

    @CrossOrigin
    @GetMapping(value = "/{id}")
    public Optional<Serie> getSerieById(@PathVariable(value="id") Long id){
        logger.info("Get album by id");
        return serieService.getById(id);
    }

    @CrossOrigin
    @GetMapping(value = "/all")
    public List<Serie> getAll(){
        logger.info("Get all albums");
        return serieService.getAll();
    }

}
