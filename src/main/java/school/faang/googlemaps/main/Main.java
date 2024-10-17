package school.faang.googlemaps.main;

import school.faang.googlemaps.maincode.Location;
import school.faang.googlemaps.maincode.LocationDateEngine;

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

        LocationDateEngine locationDateEngine = new LocationDateEngine();

        List<Location> filteredLocations = locationDateEngine.filterLocations(locations,
                location -> location.getLongitude() > 0);

        locationDateEngine.processLocations(filteredLocations,
                location -> System.out.println(location.getName()));

        double baseLatitude = 37.4220;
        double baseLongitude = -122.0841;
        List<Double> distances = locationDateEngine.calculateDistance(locations, (location) -> {
            double latitudeDiff = Math.abs(location.getLatitude() - baseLatitude);
            double longitudeDiff = Math.abs(location.getLongitude() - baseLongitude);
            return Math.sqrt(Math.pow(latitudeDiff, 2) + Math.pow(longitudeDiff, 2));
        });

        distances.forEach(System.out::println);
    }
}


