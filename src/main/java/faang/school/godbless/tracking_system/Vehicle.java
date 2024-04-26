package faang.school.godbless.tracking_system;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Vehicle {
    private static int startId = 0;
    private int id;
    private boolean isBusy;
    private Location location;

    public Vehicle(Location location) {
        this.id = startId++;
        this.location = location;
    }
}
