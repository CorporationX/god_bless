package faang.school.godbless.googleMaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static faang.school.godbless.googleMaps.LocationSearchEngine.calculateDistances;
import static faang.school.godbless.googleMaps.LocationSearchEngine.filterLocations;
import static faang.school.godbless.googleMaps.LocationSearchEngine.processLocations;

public class Main {
    public static void main(String[] args) {
        List<Location> locations = new ArrayList<>(Arrays.asList(
                new Location("Eiffel Tower", 48.8584, 2.2945),
                new Location("Statue of Liberty", 40.6892, -74.0445),
                new Location("Great Wall of China", 40.4319, 116.5704)
        ));

        List<Location> filteredLocations = filterLocations(locations, (location) -> location.getLongitude() > 0);
        System.out.println(filteredLocations);
        processLocations(filteredLocations, (location) -> System.out.println(location.getName()));

        double baseLatitude = 37.4220;
        double baseLongitude = -122.0841;
        List<Double> distances = calculateDistances(locations, (location) -> {
            double latitudeDiff = Math.abs(location.getLatitude() - baseLatitude);
            double longitudeDiff = Math.abs(location.getLongitude() - baseLongitude);
            return Math.sqrt(Math.pow(latitudeDiff, 2) + Math.pow(longitudeDiff, 2));
        });
        System.out.println(distances);
    }
}
