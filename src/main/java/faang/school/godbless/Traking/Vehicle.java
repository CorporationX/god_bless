package faang.school.godbless.Traking;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Vehicle {
    private String id;
    private volatile boolean status;
    private volatile Location location;

    public void updateLocation(int latitude, int longitude) {
        this.location = new Location(latitude, longitude);
    }

    public void updateStatus() {
        status = !status;
    }

    public Boolean getStatus() {
        return status;
    }
}

