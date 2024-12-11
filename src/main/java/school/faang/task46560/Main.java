package school.faang.task46560;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Location> locations = new ArrayList<>(Arrays.asList(
                new Location("Eiffel Tower", 48.8584, 2.2945),
                new Location("Statue of Liberty", 40.6892, -74.0445),
                new Location("Great Wall of China", 40.4319, 116.5704),
                null,
                null
        ));

        locations.forEach(System.out::println);

        LocationSearchEngine locationSearchEngine = new LocationSearchEngine();

        List<Location> filteredLocations = locationSearchEngine.filterLocations(locations,
                location -> location.getLongitude() > 0);

        locationSearchEngine.processLocations(filteredLocations,
                location -> System.out.println("Location: " + location.getName()));

        double baseLatitude = 25.40;
        double baseLongitude = -74.0445;

        List<Double> distances = locationSearchEngine.calculateDistances(locations, location -> {
            double latitudeDiff = Math.abs(location.getLatitude() - baseLatitude);
            double longitudeDiff = Math.abs(location.getLongitude() - baseLongitude);
            return Math.sqrt(Math.pow(latitudeDiff, 2) + Math.pow(longitudeDiff, 2));
        });

        distances.forEach(System.out::println);
    }
}
