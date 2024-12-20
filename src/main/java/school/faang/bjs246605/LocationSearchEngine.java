package school.faang.bjs246605;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LocationSearchEngine {

    public List<Location> filterLocations(List<Location> locations, Predicate<Location> condition)
            throws IllegalArgumentException {
        if (locations.isEmpty()) {
            throw new IllegalArgumentException("Empty list " + locations);
        }

        return locations.stream()
                .filter(condition).toList();
    }

    public void processLocations(List<Location> locations, Consumer<Location> consumer)
            throws IllegalArgumentException {
        if (locations.isEmpty()) {
            throw new IllegalArgumentException("Empty list " + locations);
        }

        locations.stream()
                .peek(consumer);
    }

    public List<Double> calculateDistances(List<Location> locations, Function<Location, Double> func)
            throws IllegalArgumentException {
        if (locations.isEmpty()) {
            throw new IllegalArgumentException("Empty list " + locations);
        }

        return locations.stream()
                .map(func).toList();
    }
}