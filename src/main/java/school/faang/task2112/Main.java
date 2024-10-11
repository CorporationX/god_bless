package school.faang.task2112;

import school.faang.task2112.location.Location;
import school.faang.task2112.location.LocationSearchEngine;

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

        List<Location> filteredLocation = LocationSearchEngine.filterLocations(locations, p -> p.getLongitude() > 0);

        LocationSearchEngine.processLocations(filteredLocation, System.out::println);

        Location targetLocation = new Location("Target", 37.4220, -122.0841);

        List<Double> distance = LocationSearchEngine.calculateDistances(locations, targetLocation, l -> {
            double latitudeDif = Math.abs(Math.abs(targetLocation.getLatitude()) - Math.abs(l.getLatitude()));
            double longitude = Math.abs(Math.abs(targetLocation.getLongitude()) - Math.abs(l.getLongitude()));
            return Math.sqrt(Math.pow(latitudeDif, 2) + Math.pow(longitude, 2));
        });

        distance.forEach(System.out::println);
    }
}
