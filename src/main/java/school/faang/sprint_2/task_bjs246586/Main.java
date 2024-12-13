package school.faang.sprint_2.task_bjs246586;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        LocationSearchEngine searchEngine = new LocationSearchEngine();

        List<Location> locations = List.of(
                new Location("Eiffel Tower", 48.8584, 2.2945),
                new Location("Statue of Liberty", 40.6892, -74.0445),
                new Location("Great Wall of China", 40.4319, 116.5704)
        );
        System.out.println("-----Locations:");
        locations.forEach(System.out::println);

        List<Location> filteredLocations =
                searchEngine.filterLocations(locations, (location) -> location.longitude() > 0);
        System.out.println("-----Filtered locations:");
        searchEngine.processLocations(filteredLocations, (location) -> System.out.println(location.name()));

        double baseLatitude = 37.4220;
        double baseLongitude = -122.0841;

        System.out.println("-----Calculating distances:");
        List<Double> distances = searchEngine.calculateDistances(locations, (location) -> {
            double latitudeDiff = Math.abs(location.latitude() - baseLatitude);
            double longitudeDiff = Math.abs(location.longitude() - baseLongitude);
            return Math.sqrt(Math.pow(latitudeDiff, 2) + Math.pow(longitudeDiff, 2));
        });
        System.out.println("baseLatitude: " + baseLatitude);
        System.out.println("baseLongitude: " + baseLongitude);
        System.out.println("distances: " + distances);
    }
}
