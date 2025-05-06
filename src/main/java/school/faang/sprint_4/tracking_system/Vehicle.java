package school.faang.sprint_4.tracking_system;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Vehicle {
    private String id;
    private String status;
    private Location location;

    private void updateStatus(String status) {
        this.status = status;
    }

    private void updateLocation(Location location) {
        this.location = location;
    }
}
