package school.faang;

import lombok.Getter;

@Getter
public class Location {
    private final String name;
    private final double latitude;
    private final double longitude;

    public Location(String name, double latitude, double longitude) {
        validateName(name);
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    private void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("The name can't be null or empty.");
        }
    }
}
