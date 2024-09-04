package faang.school.godbless.BJS2_25412;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@Getter
@EqualsAndHashCode
@AllArgsConstructor
@ToString
public class Vehicle {
    private final int id;
    private Status status;
    private Locaton location;

    public void setLocation() {
        double newLatitude = location.latitude() + new Random().nextDouble(-0.030000, 0.030000);
        double newLongtitude = location.longitude() + new Random().nextDouble(-0.030000, 0.030000);
        location = new Locaton(newLatitude, newLongtitude);
    }

    public void setStatus() {
        status = Status.values()[ThreadLocalRandom.current().nextInt(Status.values().length)];
    }
}
