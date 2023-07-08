package faang.school;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Vehicle {
    private int id;
    private boolean status;
    private Location currentLocation;

    public void updateStatus(boolean status) {
        this.status = status;
    }

    public void updateLocation(Location location) {
        currentLocation = location;
    }
}
