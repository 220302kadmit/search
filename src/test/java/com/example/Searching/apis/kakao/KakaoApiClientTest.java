package com.example.Searching.apis.kakao;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.example.Searching.apis.kakao.dto.KakaoSearchResult;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class KakaoApiClientTest {

    @Autowired
    private KakaoApiClient kakaoApiClient;

    @Test
    public void testSearchPlace() {
        String query = "카페";

        KakaoSearchResult result = kakaoApiClient.searchPlace(query);

        assertThat(result).isNotNull();
        assertThat(result.getDocuments()).isNotNull();
        assertThat(result.getDocuments().size()).isGreaterThan(0);
    }
}
