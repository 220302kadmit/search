package com.example.Searching.apis.kakao.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Searching.apis.kakao.KakaoApiClient;

@RestController
public class KakaoController {

    private final KakaoApiClient kakaoApiClient;

    public KakaoController(KakaoApiClient kakaoApiClient) {
        this.kakaoApiClient = kakaoApiClient;
    }

    @GetMapping("/kakao/search")
    public ResponseEntity<String> search(@RequestParam String query) {
        return kakaoApiClient.searchSomething(query);
    }
}
