package com.example.Searching.apis.searching.place.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Searching.apis.searching.place.dto.PlaceDto;
import com.example.Searching.apis.searching.place.service.PlaceSearchService;

@RestController
public class PlaceSearchController {

    @Autowired
    private PlaceSearchService placeSearchService;

    @GetMapping("/place/search")
    public List<PlaceDto> searchPlace(@RequestParam String keyword) {
        return placeSearchService.searchPlace(keyword);
    }
}
