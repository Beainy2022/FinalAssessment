package com.Eurisko.Final.Exam.PhotoAlbumGallery.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "geolocations")
public class Geo {
    private String lat;  // Latitude
    private String lng;  // Longitude

    // Constructors
    public Geo() {}

    public Geo(String lat, String lng) {
        this.lat = lat;
        this.lng = lng;
    }

    // Getters and setters
    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

}
