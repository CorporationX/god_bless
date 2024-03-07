package faang.school.godbless.trackingsys;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Random;

@Data
@AllArgsConstructor
public class Vehicle {

    private static final Random RANDOM = new Random();
    private long id;
    private volatile Status status;
    private volatile Location location;

    public void checkCondition() {
        System.out.println(String.format("Vehicle %d is currently %s. Position: latitude - %d, longitude - %d",
                id,
                status.getStatus(),
                location.getLatitude(),
                location.getLongitude()));
        changeLocation();
    }

    private synchronized void changeLocation() {
        location = new Location(location.getLatitude() + RANDOM.nextInt(3 + 3) - 3, location.getLongitude() + RANDOM.nextInt(3 + 3) - 3);
    }
}