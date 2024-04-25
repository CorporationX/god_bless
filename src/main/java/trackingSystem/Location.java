package trackingSystem;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public final class Location {
    private final double latitude;
    private final double longitude;

    public Location getNewLocation(double newLatitude, double newLongitude) {
        return new Location(newLatitude, newLongitude);
    }
}
