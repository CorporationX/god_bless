package faang.school.godbless.sprint_3.google_maps;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LocationSearchEngine {
    public List<Location> filterLocations(List<Location> locations, Predicate<Location> predicate) {
        if (locations.isEmpty()) {
            throw new IllegalArgumentException("You are giving an empty list");
        }
        return locations.stream().filter(predicate).toList();
    }

    public void processLocations(List<Location> locations, Consumer<Location> consumer) {
        if (locations.isEmpty()) {
            throw new IllegalArgumentException("You are giving an empty list");
        }
        locations.forEach(consumer);
    }

    public List<Double> calculateDistances(List<Location> locations, Function<Location, Double> function) {
        if (locations.isEmpty()) {
            throw new IllegalArgumentException("You are giving an empty list");
        }
        return locations.stream().map(function).toList();
    }
}
