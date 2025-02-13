package school.faang.task_60008;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Slf4j
public class Main {
    public static void main(String[] args) {
        LinkedList<Location> locations = new LinkedList<>(Arrays.asList(
                new Location("Eiffel Tower", 48.8584, 2.2945),
                new Location("Statue of Liberty", 40.6892, -74.0445),
                new Location("Great Wall of China", 40.4319, 116.5704)
        ));

        LocationSearchEngine searchEngine = new LocationSearchEngine();

        List<Location> filteredLocations = searchEngine.filterLocations(
                locations, (location) -> location.getLongitude() > 0);
        log.info("Filtered locations:\n\t{}", filteredLocations);

        searchEngine.processLocations(filteredLocations, (location) -> System.out.println(location.getName()));

        double baseLatitude = 37.4220;
        double baseLongitude = -122.0841;
        List<Double> distances = searchEngine.calculateDistances(locations, (location) -> {
            double latitudeDiff = Math.abs(location.getLatitude() - baseLatitude);
            double longitudeDiff = Math.abs(location.getLongitude() - baseLongitude);
            return Math.sqrt(Math.pow(latitudeDiff, 2) + Math.pow(longitudeDiff, 2));
        });
        for (int i = 0; i < locations.size(); i++) {
            log.info("Distance between {} and the given point is {}\n", locations.get(i), distances.get(i));
        }
    }
}
