package school.faang;

import lombok.Getter;

@Getter
public class Location {
    private final String name;
    private final double latitude;
    private final double longitude;

    public Location(String name, double latitude, double longitude) {
        validateName(name);
        validateCoordinates(latitude, longitude);
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    private void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("The name can't be null or empty.");
        }
    }

    private void validateCoordinates(double latitude, double longitude) {
        if (latitude < -90 || latitude > 90) {
            throw new IllegalArgumentException("Latitude must be in the range [-90, 90]");
        }
        if (longitude < -180 || longitude > 180) {
            throw new IllegalArgumentException("Longitude must be in the range [-180, 180]");
        }
    }

}
