package com.example.Searching.apis.searching.place.dto;

public class PlaceDto {
    private String name;
    private String address;
    private String mapUrl;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMapUrl() {
        return mapUrl;
    }

    public void setMapUrl(String mapUrl) {
        this.mapUrl = mapUrl;
    }
    public void setTitle(String title) {
        this.name = title;
    }

    public void setUrl(String url) {
        this.mapUrl = url;
    }


}
