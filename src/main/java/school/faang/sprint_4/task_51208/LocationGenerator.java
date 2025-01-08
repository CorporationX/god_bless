package school.faang.sprint_4.task_51208;

import java.util.Random;

public class LocationGenerator {
    private static final int LATITUDE_LIMIT = 90;
    private static final int LONGITUDE_LIMIT = 180;

    public static Location generateRandomLocation() {
        Random random = new Random();
        int randomLatitude = random.nextInt(LATITUDE_LIMIT * 2) - LATITUDE_LIMIT;
        int randomLongitude = random.nextInt(LONGITUDE_LIMIT * 2) - LONGITUDE_LIMIT;
        return new Location(randomLatitude, randomLongitude);
    }
}
