package faang.school.godbless.googleMaps;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LocationSearchEngine {
    public List<Location> filterLocations(List<Location> locations, Predicate<Location> filter) {
        checkLocations(locations);
        List<Location> filtered = new ArrayList<>();
        for (Location location : locations) {
            if (filter.test(location)) {
                filtered.add(location);
            }
        }

        return filtered;
    }

    public void processLocations(List<Location> locations, Consumer<Location> consumer) {
        checkLocations(locations);
        for (Location location : locations) {
            consumer.accept(location);
        }
    }

    public List<Double> calculateDistances(List<Location> locations, Function<Location, Double> function) {
        checkLocations(locations);
        List<Double> calculated = new ArrayList<>();
        for (Location location : locations) {
            calculated.add(function.apply(location));
        }

        return calculated;
    }

    private static void checkLocations(List<Location> locations) {
        if (locations.isEmpty()) {
            throw new IllegalArgumentException("Locations is empty");
        }
    }
}
