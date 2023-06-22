package google_maps;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LocationSearchEngine {
    public List<Location> filterLocations(List<Location> locations, Predicate<Location> condition) {
        return locations.stream()
                .filter(condition)
                .toList();
    }

    public void processLocations(List<Location> locations, Consumer<Location> actionForEachEl) {
        locations.forEach(actionForEachEl);
    }

    public List<Double> calculateDistances(List<Location> locations, Function<Location, Double> calculateDistance) {
        return locations.stream()
                .map(calculateDistance)
                .toList();
    }
}
