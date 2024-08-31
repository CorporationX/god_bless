package faang.school.godbless.TrackingSystem;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public class Vehicle {
    private int id;
    @Setter
    private boolean isAvailable;
    private Location location;

    public void setLocation(Location location) {
        this.location = new Location(location.getLatitude(), location.getLongitude());
    }

    public void setLocation(int latitude, int longitude) {
        this.location = new Location(latitude, longitude);
    }
}
