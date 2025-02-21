package googlemaps;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class LocationSearchEngine {
    private static final Logger logger = Logger.getLogger(LocationSearchEngine.class.getName());
    private static final double ORIGIN_LATITUDE = 0.0;
    private static final double ORIGIN_LONGITUDE = 0.0;
    private static final String FILTERING_LOCATIONS = "Filtering locations...";
    private static final String ADDED_LOCATION = "Added location: ";
    private static final String PROCESSING_LOCATIONS = "Processing locations...";
    private static final String PROCESSED_LOCATION = "Processed location: ";
    private static final String CALCULATING_DISTANCES = "Calculating distances...";
    private static final String CALCULATED_DISTANCE = "Calculated distance: ";

    public static List<Location> filterLocations(List<Location> locations, Predicate<Location> predicate) {
        logger.info(FILTERING_LOCATIONS);
        return locations.stream()
                .filter(predicate)
                .peek(LocationSearchEngine::logAddedLocation)
                .collect(Collectors.toList());
    }

    public static void processLocations(List<Location> locations, Consumer<Location> consumer) {
        logger.info(PROCESSING_LOCATIONS);
        locations.forEach(location -> {
            consumer.accept(location);
            logProcessedLocation(location);
        });
    }

    public static List<Double> calculateDistances(List<Location> locations,
                                                  Function<Location, Double> distanceCalculator) {
        logger.info(CALCULATING_DISTANCES);
        return locations.stream()
                .map(distanceCalculator)
                .peek(LocationSearchEngine::logCalculatedDistance)
                .collect(Collectors.toList());
    }

    public static double calculateDistanceFromOrigin(Location location) {
        double latitudeDifference = location.latitude() - ORIGIN_LATITUDE;
        double longitudeDifference = location.longitude() - ORIGIN_LONGITUDE;
        return Math.sqrt(Math.pow(latitudeDifference, 2) + Math.pow(longitudeDifference, 2));
    }

    public static void logAddedLocation(Location location) {
        logger.info(ADDED_LOCATION + location);
    }

    public static void logProcessedLocation(Location location) {
        logger.info(PROCESSED_LOCATION + location);
    }

    public static void logCalculatedDistance(Double distance) {
        logger.info(CALCULATED_DISTANCE + distance);
    }
}
