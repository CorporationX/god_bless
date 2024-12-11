package school.faang.task46560;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Location {
    private static final double MAX_LATITUDE = 90;
    private static final double MIN_LATITUDE = -90;
    private static final double MAX_LONGITUDE = 180;
    private static final double MIN_LONGITUDE = -180;

    private final String name;
    private final double latitude;
    private final double longitude;

    public Location(String name, double latitude, double longitude) {
        validate(name, latitude, longitude);

        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    private void validate(String name, double latitude, double longitude) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be blank");
        }
        if (latitude < MIN_LATITUDE || latitude > MAX_LATITUDE) {
            throw new IllegalArgumentException("Invalid latitude");
        }
        if (longitude < MIN_LONGITUDE || longitude > MAX_LONGITUDE) {
            throw new IllegalArgumentException("Invalid longitude");
        }
    }
}
