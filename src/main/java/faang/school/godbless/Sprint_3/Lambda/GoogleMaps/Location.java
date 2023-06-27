package faang.school.godbless.Sprint_3.Lambda.GoogleMaps;

import lombok.Getter;

@Getter
public class Location {
    private String name;
    private double latitude;
    private double longitude;

    public Location(String name, double latitude, double longitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
