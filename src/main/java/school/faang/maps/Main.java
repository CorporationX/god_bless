package school.faang.maps;

import java.util.List;

/**
 * @author Danil Pudovkin
 * @since 11.06.2025
 */
public class Main {

    public static void main(String[] args) {
        var locations = List.of(
                new Location("Eiffel Tower", 48.8584, 2.2945),
                new Location("Statue of Liberty", 40.6892, -74.0445),
                new Location("Great Wall of China", 40.4319, 116.5704)
        );
        var searchEngine = new LocationSearchEngine();

        var filteredLocations = searchEngine.filterLocations(locations, location -> location.longitude() > 0);
        searchEngine.processLocations(filteredLocations, location -> System.out.println(location.name()));

        double baseLatitude = 37.4220;
        double baseLongitude = -122.0841;
        var distances = searchEngine.calculateDistances(locations, location -> {
            var latitudeDiff = Math.abs(location.latitude() - baseLatitude);
            var longitudeDiff = Math.abs(location.longitude() - baseLongitude);
            return Math.sqrt(Math.pow(latitudeDiff, 2) + Math.pow(longitudeDiff, 2));
        });
        System.out.println(distances);
    }
}
