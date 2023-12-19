package Witcher;

import lombok.Getter;

@Getter
public class City {
    private String name;
    private Location location;
    private int distanceToHerald;

    public City(String name, Location location, int distanceToHerald) {
        this.name = name;
        this.location = location;
        this.distanceToHerald = distanceToHerald;
    }
}
