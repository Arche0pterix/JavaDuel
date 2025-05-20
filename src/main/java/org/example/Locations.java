package org.example;

public class Locations extends LocationManager {
    String name;
    int locationId;
    int areaLevel;

    public Locations(String name, int areaLevel, int locationId) {
        this.name = name;
        this.locationId = locationId;
        this.areaLevel = areaLevel;
    }
}
