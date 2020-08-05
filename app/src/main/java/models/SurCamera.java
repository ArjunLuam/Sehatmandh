package com.example.mask_detector.model;

import java.io.Serializable;

public class SurCamera implements Serializable {
    String Latitude;
    String Longitude;
    String Place;
    String mask;
    String no_mask;

    public SurCamera() {
    }

    public SurCamera(String latitude, String longitude, String place, String mask, String no_mask) {
        Latitude = latitude;
        Longitude = longitude;
        Place = place;
        this.mask = mask;
        this.no_mask = no_mask;
    }

    public String getLatitude() {
        return Latitude;
    }

    public String getLongitude() {
        return Longitude;
    }

    public String getPlace() {
        return Place;
    }

    public String getMask() {
        return mask;
    }

    public String getNo_mask() {
        return no_mask;
    }
}
