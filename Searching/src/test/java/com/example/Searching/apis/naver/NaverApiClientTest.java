package com.example.Searching.apis.naver;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.example.Searching.apis.naver.dto.NaverSearchResult;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class NaverApiClientTest {

    @Autowired
    private NaverApiClient naverApiClient;

    @Test
    public void testSearchPlace() {
        String query = "카페";

        NaverSearchResult result = naverApiClient.searchPlace(query);

        assertThat(result).isNotNull();
        assertThat(result.getItems()).isNotNull();
        assertThat(result.getItems().size()).isGreaterThan(0);
    }
}
