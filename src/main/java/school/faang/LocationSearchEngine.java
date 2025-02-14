package school.faang;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LocationSearchEngine {
    public List<Location> filterLocations(List<Location> locations, Predicate<Location> condition) {
        validateLocations(locations);
        validateArgument(condition, "Condition predicate cannot be null");

        return locations.stream()
                .filter(condition)
                .toList();
    }

    public void processLocations(List<Location> locations, Consumer<Location> action) {
        validateLocations(locations);
        validateArgument(action, "Action consumer cannot be null");

        locations.forEach(action);
    }

    public List<Double> calculateDistances(List<Location> locations, Function<Location, Double> distanceFunction) {
        validateLocations(locations);
        validateArgument(distanceFunction, "Distance function cannot be null");

        return locations.stream()
                .map(distanceFunction)
                .toList();
    }

    private void validateLocations(List<Location> locations) {
        if (locations == null) {
            throw new LocationValidationException("Locations list cannot be null");
        }
    }

    private <T> void validateArgument(T arg, String message) {
        if (arg == null) {
            throw new IllegalArgumentException(message);
        }
    }
}
