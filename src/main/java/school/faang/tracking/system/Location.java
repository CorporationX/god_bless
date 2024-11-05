package school.faang.tracking.system;

import java.util.concurrent.ThreadLocalRandom;

public record Location(double latitude, double longitude) {
    private static final int MIN_LATITUDE = 1;
    private static final int MAX_LATITUDE = 100;
    private static final int MIN_LONGITUDE = 1;
    private static final int MAX_LONGITUDE = 100;

    public static Location generateRandomLocation() {
        return new Location(
                ThreadLocalRandom.current().nextDouble(MIN_LATITUDE, MAX_LATITUDE),
                ThreadLocalRandom.current().nextDouble(MIN_LONGITUDE, MAX_LONGITUDE));
    }

    @Override
    public String toString() {
        return "(" + latitude + ", " + longitude + ")";
    }
}
