package com.example.Searching.apis.naver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Searching.apis.naver.NaverApiClient;
import com.example.Searching.apis.naver.dto.NaverSearchResult;

@Service
public class NaverApiService {

    private final NaverApiClient naverApiClient;

    @Autowired
    public NaverApiService(NaverApiClient naverApiClient) {
        this.naverApiClient = naverApiClient;
    }

    public NaverSearchResult search(String query) {
        return naverApiClient.search(query);
    }
}
