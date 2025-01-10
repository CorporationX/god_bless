package school.faang.bjs251235;

import java.util.Random;

public class LocationGenerator {
    private static final int LATITUDE_LIM = 90;
    private static final int LONGITUDE_LIM = 180;
    private static final int MULTIPLIER = 2;

    public static Location generateRandomLocation() {
        Random random = new Random();
        int randomLatitude = random.nextInt(LATITUDE_LIM * MULTIPLIER) - LATITUDE_LIM;
        int randomLongitude = random.nextInt(LONGITUDE_LIM * MULTIPLIER) - LONGITUDE_LIM;
        return new Location(randomLatitude, randomLongitude);
    }
}