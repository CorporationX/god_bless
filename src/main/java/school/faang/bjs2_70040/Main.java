package school.faang.bjs2_70040;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
public class Main {
    public static void main(String[] args) {
        List<Location> locations = new ArrayList<>(Arrays.asList(
                new Location("Eiffel Tower", 48.8584, 2.2945),
                new Location("Statue of Liberty", 40.6892, -74.0445),
                new Location("Great Wall of China", 40.4319, 116.5704)
        ));

        LocationSearchEngine searchEngine = new LocationSearchEngine();

        // Filter by longitude
        List<Location> filteredLocations = searchEngine.filterLocations(locations, (location) -> location.getLongitude() > 0);

        // Print filtered locations
        searchEngine.processLocations(filteredLocations, (location) -> System.out.println(location.getName()));

        // Calculate distances from a point to every location
        double baseLatitude = 37.4220;
        double baseLongitude = -122.0841;
        List<Double> distances = searchEngine.calculateDistances(locations, (location) -> {
            double latitudeDiff = Math.abs(location.getLatitude() - baseLatitude);
            double longitudeDiff = Math.abs(location.getLongitude() - baseLongitude);
            return Math.sqrt(Math.pow(latitudeDiff, 2) + Math.pow(longitudeDiff, 2));
        });

        for (int i = 0; i < locations.size(); i++) {
            Location location = locations.get(i);
            Double distance = distances.get(i);

            log.info("Distance from ({}, {}) to {} ({}, {}): {}",
                    baseLatitude,
                    baseLongitude,
                    location.getName(),
                    location.getLatitude(),
                    location.getLongitude(),
                    distance
            );
        }
    }
}
