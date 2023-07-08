package faang.school.godbless.sprint5.multithreading_conc.task8_tracking;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Random;

@Getter
@ToString
@AllArgsConstructor
public final class Location {

    private static final Random RANDOM = new Random();
    private int latitude;

    private int longitude;

    public Location() {
        this.latitude = RANDOM.nextInt(-90, 90);
        this.longitude = RANDOM.nextInt(-180, 180);
    }

    public Location getNewLocation() {
        return new Location(latitude + RANDOM.nextInt(-10, 10), longitude + RANDOM.nextInt(-10, 10));
    }
}
