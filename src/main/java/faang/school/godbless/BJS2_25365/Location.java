package faang.school.godbless.BJS2_25365;

import java.util.concurrent.ThreadLocalRandom;

public record Location(int latitude, int longitude) {
    public Location() {
        this(ThreadLocalRandom.current().nextInt(0, 100), ThreadLocalRandom.current().nextInt(0, 100));
    }

    public Location changeCurrentLocation() {
        return new Location(this.latitude + ThreadLocalRandom.current().nextInt(-15, 15),
                this.longitude + ThreadLocalRandom.current().nextInt(-15, 15));
    }
}
