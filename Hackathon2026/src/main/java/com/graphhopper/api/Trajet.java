package com.graphhopper.api;

public class Trajet {
    private String depart;
    private String destination;
    private int nombrePlaces;
    private String transport;


    public  Trajet(String depart, String destination, int nombrePlaces , String transport) {
        this.depart = depart;
        this.destination = destination;
        this.nombrePlaces = nombrePlaces;
        this.transport = transport;
    }
    public String getDepart() {
        return depart;
    }
    public String getDestination() {
        return destination;
    }
    public int getNombrePlaces() {
        return nombrePlaces;
    }
    public String getTransport() {
        return transport;

    }


}
