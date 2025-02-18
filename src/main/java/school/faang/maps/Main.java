package school.faang.maps;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final double BASE_LATITUDE = 59.9343;
    private static final double BASE_LONGITUDE = 30.3351;

    public static void main(String[] args) {
        List<Location> locations = List.of(
                new Location("Taj Mahal", 27.1751, 78.0421),
                new Location("Petra", 30.3285, 35.4444),
                new Location("Sydney Opera House", 33.8568, 151.2153),
                new Location("Machu Picchu", 13.1631, 72.5450),
                new Location("Great Wall of China", 40.4319, 116.5704)
        );

        LocationSearchEngine searchEngine = new LocationSearchEngine();

        List<Location> filteredLocations = searchEngine.filterLocations(locations,
                location -> location.getLongitude() > 0);

        searchEngine.processLocations(filteredLocations, location -> System.out.println(location.getName()));

        List<Double> distances = searchEngine.calculateDistances(locations, location -> {
            double latitudeDiff = Math.abs(location.getLatitude() - BASE_LATITUDE);
            double longitudeDiff = Math.abs(location.getLongitude() - BASE_LONGITUDE);
            return Math.sqrt(Math.pow(latitudeDiff, 2) + Math.pow(longitudeDiff, 2));
        });
        System.out.println("Distances: " + distances);
    }
}
