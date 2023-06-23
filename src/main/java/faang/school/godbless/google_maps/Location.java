package faang.school.godbless.google_maps;

import lombok.Getter;

@Getter

public class Location {

    private String name;
    private double latitude;
    private double longitude;

    public Location(String name, double latitude, double longitude) {
        validateName(name);

        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    private void validateName(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("Name can't be empty");
        }
    }
}
