package com.manga.bdgest.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloWorldController {

    @RequestMapping("/")
    public ResponseEntity<JsonNode> get() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode json = mapper.readTree("{\"id\": \"132\", \"name\": \"Alice\"}");
        return ResponseEntity.ok(json);
    }

    @RequestMapping("/hh")
    public ResponseEntity<JsonNode> hello() throws JsonProcessingException
    {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode json = mapper.readTree("{\"id\": \"456\", \"name\": \"Saucisse\"}");
        return ResponseEntity.ok(json);
    }
}
