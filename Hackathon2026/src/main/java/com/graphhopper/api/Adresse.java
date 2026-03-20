package com.graphhopper.api;

public class Adresse {

    private String ville;
    private double latitude;
    private double longitude;

    public Adresse(String ville, double latitude, double longitude) {
        this.ville = ville;
        this.latitude = latitude;
        this.longitude = longitude;

    }
    public String getVille() {
        return ville;
    }
    public double getLatitude() {
        return latitude;
    }
    public double getLongitude() {
        return longitude;
    }
}
