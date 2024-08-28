package faang.school.godbless.BJS2_25405;

import java.util.concurrent.ThreadLocalRandom;

public record Location(double latitude, double longitude) {
    private static final ThreadLocalRandom RANDOM = ThreadLocalRandom.current();

    public Location nextLocation() {
        double nextLatitude = RANDOM.nextDouble(latitude - 10.0, latitude + 11.0);
        double nextLongitude = RANDOM.nextDouble(longitude - 10.0, longitude + 11.0);
        return new Location(nextLatitude, nextLongitude);
    }

    @Override
    public String toString() {
        return "Location{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
