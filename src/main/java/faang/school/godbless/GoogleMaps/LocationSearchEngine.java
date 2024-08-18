package faang.school.godbless.GoogleMaps;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LocationSearchEngine {
    List<Location> filterLocations(List<Location> locations, Predicate<Location> predicate) {
        if (locations == null || predicate == null) {
            return null;
        }
        return locations.stream().filter(predicate).toList();
    }

    void processLocations(List<Location> locations, Consumer<Location> consumer) {
        if (locations == null || consumer == null) {
            return;
        }
        locations.forEach(consumer);
    }

    List<Double> calculateDistances(List<Location> locations, Function<Location, Double> function) {
        if (locations == null || function == null) {
            return null;
        }
        return locations.stream().map(function).toList();
    }
}
