package school.faangSprint4.t22;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Vehicle {
    private final String id;
    private volatile String status;
    private volatile Location location;

    public void updateLocation(Location newLocation) {
        this.location = newLocation;
    }

    @Override
    public String toString() {
        return "Vehicle{id='" + id + "', status='" + status + "', location=" + location + '}';
    }
}