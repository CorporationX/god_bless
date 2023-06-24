package faang.school.godbless.google_maps;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LocationSearchEngine {

    public List<Location> filterLocation(List<Location> locations, Predicate<Location> predicate) {
        if (locations.isEmpty()) {
            throw new IllegalStateException("empty list");
        }

        return locations.stream().filter(predicate).collect(Collectors.toList());
    }

    public void processLocations(List<Location> locations, Consumer<Location> consumer) {
        if (locations.isEmpty()) {
            throw new IllegalStateException("empty list");
        }

        locations.forEach(consumer);
    }

    public List<Double> calculateDistance(List<Location> locations, Function<Location, Double> function) {
        if (locations.isEmpty()) {
            throw new IllegalStateException("empty list");
        }

        return locations.stream().map(function).collect(Collectors.toList());
    }
}
