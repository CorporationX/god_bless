package school.faang;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        LocationSearchEngine engine = new LocationSearchEngine();

        List<Location> locations = new ArrayList<>(Arrays.asList(
                new Location("Eiffel Tower", 48.8584, 2.2945),
                new Location("Statue of Liberty", 40.6892, -74.0445),
                new Location("Great Wall of China", 40.4319, 116.5704)
        ));

        List<Location> filteredLocations = engine.filterLocation(locations,
                (location) -> location.getLongitude() > 0);
        engine.processLocations(filteredLocations,
                (location) -> System.out.printf("Локация: %s\n", location.getName()));

        double baseLatitude = 37.4220;
        double baseLongitude = -122.0841;
        List<Double> distances = engine.calculateDistances(locations, (location) -> {
            double latitudeDiff = Math.abs(location.getLatitude() - baseLatitude);
            double longitudeDiff = Math.abs(location.getLongitude() - baseLongitude);
            return Math.sqrt(Math.pow(latitudeDiff, 2) + Math.pow(longitudeDiff, 2));
        });

        engine.processDistances(distances,
                (distance) -> System.out.printf("Distance: %s\n", distance));
    }
}
