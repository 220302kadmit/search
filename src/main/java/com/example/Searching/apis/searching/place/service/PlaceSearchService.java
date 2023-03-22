package com.example.Searching.apis.searching.place.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Searching.apis.kakao.KakaoApiClient;
import com.example.Searching.apis.kakao.dto.KakaoSearchResult;
import com.example.Searching.apis.naver.NaverApiClient;
import com.example.Searching.apis.naver.dto.NaverSearchResult;
import com.example.Searching.apis.searching.place.dto.PlaceDto;

@Service
public class PlaceSearchService {

    @Autowired
    private KakaoApiClient kakaoApiClient;

    @Autowired
    private NaverApiClient naverApiClient;

    public List<PlaceDto> searchPlace(String keyword) {

        List<PlaceDto> result = new ArrayList<>();

        // 카카오 API로 장소 검색
        KakaoSearchResult kakaoSearchResult = kakaoApiClient.searchPlace(keyword);
        List<PlaceDto> kakaoPlaces = convertKakaoSearchResultToPlaceDto(kakaoSearchResult.getDocuments());

        // 네이버 API로 장소 검색
        NaverSearchResult naverSearchResult = naverApiClient.searchPlace(keyword);
        List<PlaceDto> naverPlaces = convertNaverSearchResultToPlaceDto(naverSearchResult.getItems());

        // 검색 결과 중복 제거
        Set<PlaceDto> set = new HashSet<>();
        set.addAll(kakaoPlaces);
        set.addAll(naverPlaces);
        List<PlaceDto> places = new ArrayList<>(set);

        // 최대 10개의 장소 정보 반환
        for (int i = 0; i < places.size() && i < 10; i++) {
            result.add(places.get(i));
        }

        return result;
    }

    private List<PlaceDto> convertKakaoSearchResultToPlaceDto(List<KakaoSearchResult.Document> documents) {
        List<PlaceDto> places = new ArrayList<>();

        for (KakaoSearchResult.Document document : documents) {
            PlaceDto place = new PlaceDto();
            place.setTitle(document.getTitle());
            place.setAddress(document.getRoadAddress().orElse(document.getAddress()));
            place.setUrl(document.getUrl());

            places.add(place);
        }

        return places;
    }

    private List<PlaceDto> convertNaverSearchResultToPlaceDto(List<NaverSearchResult.Item> items) {
        List<PlaceDto> places = new ArrayList<>();

        for (NaverSearchResult.Item item : items) {
            PlaceDto place = new PlaceDto();
            place.setTitle(item.getTitle());
            place.setAddress(item.getAddress());
            place.setUrl(item.getLink());

            places.add(place);
        }

        return places;
    }
}
