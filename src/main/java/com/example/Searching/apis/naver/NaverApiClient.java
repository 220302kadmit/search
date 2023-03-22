package com.example.Searching.apis.naver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.Searching.apis.naver.dto.NaverSearchResult;

@Service
public class NaverApiClient {

    private final RestTemplate restTemplate;
    private final String apiUrl;
    private final String clientId;
    private final String clientSecret;

    @Autowired
    public NaverApiClient(RestTemplate restTemplate,
                          @Value("${api.naver.url}") String apiUrl,
                          @Value("${api.naver.clientId}") String clientId,
                          @Value("${api.naver.clientSecret}") String clientSecret) {
        this.restTemplate = restTemplate;
        this.apiUrl = apiUrl;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
    }

    public NaverSearchResult searchPlace(String query) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Naver-Client-Id", clientId);
        headers.set("X-Naver-Client-Secret", clientSecret);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<NaverSearchResult> response = restTemplate.exchange(
                apiUrl + "?query=" + query + "&display=10",
                HttpMethod.GET,
                entity,
                NaverSearchResult.class
        );

        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        } else {
            throw new NaverApiException("Naver API 호출 실패: " + response.getStatusCode());
        }
    }
    public NaverSearchResult search(String query) {
        return restTemplate.getForObject("https://openapi.naver.com/v1/search/local.json?query={query}", NaverSearchResult.class, query);
    }

}
