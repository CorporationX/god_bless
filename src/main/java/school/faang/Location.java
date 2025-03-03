package school.faang;

import java.util.Random;

public record Location(double latitude, double longitude) {
    private static final Random RANDOM = new Random();
    private static final double MIN_LAT = -90.0;
    private static final double MAX_LAT = 90.0;
    private static final double MIN_LON = -180.0;
    private static final double MAX_LON = 180.0;

    public static Location generateRandomLocation() {
        double latitude = MIN_LAT + (MAX_LAT - MIN_LAT) * RANDOM.nextDouble();
        double longitude = MIN_LON + (MAX_LON - MIN_LON) * RANDOM.nextDouble();
        return new Location(latitude, longitude);
    }

    public String getCoordinates() {
        return "Latitude: " + latitude + ", Longitude: " + longitude;
    }
}
