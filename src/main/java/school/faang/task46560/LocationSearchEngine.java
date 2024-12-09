package school.faang.task46560;

import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LocationSearchEngine {
    public List<Location> filterLocations(List<Location> locations,
                                          Predicate<Location> filterPredicate) {
        validateLocations(locations);
        if (filterPredicate == null) {
            throw new IllegalArgumentException("filterPredicate cannot be null");
        }

        locations.removeIf(Objects::isNull);

        return locations.stream()
                .filter(filterPredicate)
                .toList();
    }

    public void processLocations(List<Location> locations,
                                 Consumer<Location> consumer) {
        validateLocations(locations);
        if (consumer == null) {
            throw new IllegalArgumentException("consumer cannot be null");
        }

        locations.stream().filter(Objects::nonNull).forEach(consumer);
    }

    public List<Double> calculateDistances(List<Location> locations,
                                           Function<Location, Double> distanceFunction) {
        validateLocations(locations);
        if (distanceFunction == null) {
            throw new IllegalArgumentException("distanceFunction cannot be null");
        }

        return locations.stream().filter(Objects::nonNull).map(distanceFunction).toList();
    }

    private void validateLocations(List<Location> locations) {
        if (locations == null || locations.isEmpty()) {
            System.out.println("No locations found");
        }
    }
}
