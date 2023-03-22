package com.example.Searching.apis.searching.place.dto;

import java.util.List;

public class PlaceSearchResponseDto {
    private List<PlaceDto> places;

    public List<PlaceDto> getPlaces() {
        return places;
    }

    public void setPlaces(List<PlaceDto> places) {
        this.places = places;
    }
}
