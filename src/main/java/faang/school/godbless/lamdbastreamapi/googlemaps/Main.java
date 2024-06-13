package faang.school.godbless.lamdbastreamapi.googlemaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Location> locations = new ArrayList<>(Arrays.asList(
                new Location("Eiffel Tower", 48.8584, 2.2945),
                new Location("Statue of Liberty", 40.6892, -74.0445),
                new Location("Great Wall of China", 40.4319, 116.5704)
        ));

        LocationSearchEngine searchEngine = new LocationSearchEngine();
        List<Location> filteredLocations = searchEngine.filterLocations(
                locations, (location) -> location.longitude() > 0
        );
        System.out.println(filteredLocations);

        searchEngine.processLocations(filteredLocations, (location) -> System.out.println(location.name()));

        double baseLatitude = 37.4220;
        double baseLongitude = -122.0841;
        List<Double> distances = searchEngine.calculateDistances(locations, (location) -> {
            double latitudeDiff = Math.abs(location.latitude() - baseLatitude);
            double longitudeDiff = Math.abs(location.longitude() - baseLongitude);
            return Math.sqrt(Math.pow(latitudeDiff, 2) + Math.pow(longitudeDiff, 2));
        });
        System.out.println(distances);
    }
}
