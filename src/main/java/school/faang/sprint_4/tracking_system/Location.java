package school.faang.sprint_4.tracking_system;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public final class Location {
    private final double latitude;
    private final double longitude;

    @Override
    public String toString() {
        return String.format("(%f, %f)", latitude, longitude);
    }
}
