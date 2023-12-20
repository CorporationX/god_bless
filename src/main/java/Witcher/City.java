package Witcher;

import lombok.Getter;

@Getter
public class City {
    private final String name;
    private final Location location;
    private final int distanceToHerald;

    public City(String name, Location location, int distanceToHerald) {
        this.name = name;
        this.location = location;
        this.distanceToHerald = distanceToHerald;
    }
}
