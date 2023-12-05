package faang.school.godbless.TrackingSystem;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Vehicle {
    private int id;
    private volatile boolean status;
    private volatile Location location;

    public synchronized void updateLocation(Location location) {
        if (status) {
            this.location = location;
        }
    }

    public synchronized void updateStatus() {
        status = !status;
    }
}
