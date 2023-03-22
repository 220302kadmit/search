package com.example.Searching.apis.naver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Searching.apis.naver.NaverApiClient;
import com.example.Searching.apis.naver.dto.NaverSearchResult;

@RestController
public class NaverController {

    private final NaverApiClient naverApiClient;

    @Autowired
    public NaverController(NaverApiClient naverApiClient) {
        this.naverApiClient = naverApiClient;
    }

    @GetMapping("/search/naver")
    public NaverSearchResult search(@RequestParam String query) {
        return naverApiClient.searchPlace(query);
    }
}
