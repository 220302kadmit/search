package com.example.Searching;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.Searching.apis.kakao.KakaoApiException;
import com.example.Searching.apis.naver.NaverApiException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NaverApiException.class)
    public ResponseEntity<String> handleNaverApiException(NaverApiException ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
    }
    @ExceptionHandler(KakaoApiException.class)
    public ResponseEntity<String> handleKakaoApiException(KakaoApiException ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
    }
}