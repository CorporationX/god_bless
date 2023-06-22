package google;

import java.util.List;

public class Main {
    private static final LocationSearchEngine SEARCH_ENGINE = new LocationSearchEngine();

    public static void main(String[] args) {
        List<Location> locations = getLocations();

        List<Location> filteredLocations = SEARCH_ENGINE.filterLocations(locations, (location) -> location.longitude() > 0);
        SEARCH_ENGINE.processLocations(filteredLocations, (location) -> System.out.println(location.name()));

        double baseLatitude = 37.4220;
        double baseLongitude = -122.0841;
        List<Double> distances = SEARCH_ENGINE.calculateDistances(locations, (location) -> {
            double latitudeDiff = Math.abs(location.latitude() - baseLatitude);
            double longitudeDiff = Math.abs(location.longitude() - baseLongitude);
            return Math.sqrt(Math.pow(latitudeDiff, 2) + Math.pow(longitudeDiff, 2));
        });

        printDistanceToLocations(distances, locations);
    }

    private static void printDistanceToLocations(List<Double> distances, List<Location> locations) {
        for (int i = 0; i < locations.size(); i++) {
            System.out.printf("Расстояние до %s, составляет: %.2f км.\n", locations.get(i).name(), distances.get(i));
        }
    }

    private static List<Location> getLocations() {
        return List.of(
                new Location("Eiffel Tower", 48.8584, 2.2945),
                new Location("Statue of Liberty", 40.6892, -74.0445),
                new Location("Great Wall of China", 40.4319, 116.5704),
                new Location("Omsk swamp", 30.2323, 54.2082)
        );
    }
}
