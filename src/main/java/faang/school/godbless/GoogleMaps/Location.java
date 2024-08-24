package faang.school.godbless.GoogleMaps;

import lombok.Data;

@Data
public class Location {
    private String name;
    private double latitude;
    private double longitude;

    Location(String name, double latitude, double longitude) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
