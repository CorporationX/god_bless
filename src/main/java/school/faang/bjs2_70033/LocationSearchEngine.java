package school.faang.bjs2_70033;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LocationSearchEngine {
    List<Location> filterLocations(List<Location> locations, Predicate<Location> filter) {
        validateLocationsList(locations);
        return locations.stream()
                .filter(filter)
                .toList();
    }

    public void processLocations(List<Location> locations, Consumer<Location> processor) {
        locations.forEach(processor);
    }

    public List<Double> calculateDistances(List<Location> locations, Function<Location, Double> distanceCalculator) {
        validateLocationsList(locations);
        return locations.stream()
                .map(distanceCalculator)
                .toList();
    }

    private void validateLocationsList(List<Location> locations) {
        if (locations.isEmpty()) {
            throw new IllegalArgumentException("Locations is empty");
        }
    }
}