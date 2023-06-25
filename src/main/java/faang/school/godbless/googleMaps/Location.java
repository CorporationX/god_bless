package faang.school.godbless.googleMaps;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class Location {
    private String name;
    private double latitude;
    private double longitude;

    public Location(String name, double latitude, double longitude) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name can't be empty");
        }

        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
