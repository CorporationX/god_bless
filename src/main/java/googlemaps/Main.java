package googlemaps;

import java.util.List;

public class Main {

    private static final String NORTHERN_LOCATION_MESSAGE = "Northern Location: ";
    private static final String PROCESSING_LOCATION_MESSAGE = "Processing ";
    private static final String DISTANCE_MESSAGE = "Distance: ";

    public static void main(String[] args) {
        List<Location> locations = List.of(
                new Location("New York", 40.7128, -74.0060),
                new Location("London", 51.5074, -0.1278),
                new Location("Paris", 48.8566, 2.3522),
                new Location("Tokyo", 35.6762, 139.6503)
        );

        LocationSearchEngine.filterLocations(locations, location -> location.latitude() > 0)
                .forEach(location -> System.out.println(NORTHERN_LOCATION_MESSAGE + location));

        LocationSearchEngine.processLocations(locations, location ->
                System.out.println(PROCESSING_LOCATION_MESSAGE + location));

        List<Double> distances = LocationSearchEngine.calculateDistances(locations,
                LocationSearchEngine::calculateDistanceFromOrigin);

        distances.forEach(distance -> System.out.println(DISTANCE_MESSAGE + distance));
    }
}