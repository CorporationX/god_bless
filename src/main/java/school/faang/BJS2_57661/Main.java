package school.faang.BJS2_57661;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Location> locations = List.of(
                new Location("Eiffel Tower", 48.8584, 2.2945),
                new Location("Statue of Liberty", 40.6892, -74.0445),
                new Location("Great Wall of China", 40.4319, 116.5704)
        );
        LocationSearchEngine searchEngine = new LocationSearchEngine();
        List<Location> filteredLocations = searchEngine
                .filterLocations(locations, (location) -> location.getLongitude() > 0);
        searchEngine.processLocations(filteredLocations, (location) -> System.out.println(location.getName()));

        double baseLatitude = 37.4220;
        double baseLongitude = -122.0841;
        List<Double> distances = searchEngine.calculateDistances(locations, (location) -> {
            double latitudeDiff = Math.abs(location.getLatitude() - baseLatitude);
            double longitudeDiff = Math.abs(location.getLongitude() - baseLongitude);
            return Math.sqrt(Math.pow(latitudeDiff, 2) + Math.pow(longitudeDiff, 2));
        });
        System.out.println(distances);
    }
}
