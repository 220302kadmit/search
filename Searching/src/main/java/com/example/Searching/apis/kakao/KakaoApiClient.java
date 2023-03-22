package com.example.Searching.apis.kakao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.Searching.apis.kakao.dto.KakaoSearchResult;


@Service
public class KakaoApiClient {

	@Value("$api.kakao.key")
	private String kakaoApiKey;

	private final RestTemplate restTemplate;

	public KakaoApiClient(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public ResponseEntity<String> searchSomething(String query) {

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "KakaoAK " + kakaoApiKey);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        String url = "https://dapi.kakao.com/v2/local/search/address.json?query=" + query;

        return restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
    }

	public KakaoSearchResult searchPlace(String query) {
	    HttpHeaders headers = new HttpHeaders();
	    headers.set("Authorization", "KakaoAK " + kakaoApiKey);
	    HttpEntity<String> entity = new HttpEntity<>(headers);

	    String url = "https://dapi.kakao.com/v2/local/search/address.json?query=" + query;

	    ResponseEntity<KakaoSearchResult> response = restTemplate.exchange(url, HttpMethod.GET, entity, KakaoSearchResult.class);

	    return response.getBody();
	}

}
