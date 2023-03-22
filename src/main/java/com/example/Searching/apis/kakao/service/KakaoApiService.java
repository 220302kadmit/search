package com.example.Searching.apis.kakao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.Searching.apis.kakao.KakaoApiClient;
import com.example.Searching.apis.kakao.dto.KakaoSearchResult;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class KakaoApiService {

    private final KakaoApiClient kakaoApiClient;

    @Autowired
    public KakaoApiService(KakaoApiClient kakaoApiClient) {
        this.kakaoApiClient = kakaoApiClient;
    }

    public KakaoSearchResult search(String query) {
        ResponseEntity<String> response = kakaoApiClient.searchSomething(query);

        ObjectMapper objectMapper = new ObjectMapper();
        KakaoSearchResult searchResponse;
        try {
            searchResponse = objectMapper.readValue(response.getBody(), KakaoSearchResult.class);
        } catch (Exception e) {
            throw new RuntimeException("Failed to parse response from Kakao API", e);
        }

        return searchResponse;
        // TODO: 응답 결과를 파싱하는 코드 작성
    }
}
