package faang.school.godbless.google_maps;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LocationSearchEngine {
    public List<Location> filterLocations(List<Location> locations, Predicate<Location> filter) {
        if (locations == null || filter == null) {
            throw new IllegalArgumentException("Location list and filter cannot be null");
        }
        List<Location> result = new ArrayList<>();
        for (Location location : locations) {
            if (filter.test(location)) {
                result.add(location);
            }
        }
        return result;
    }

    public void processLocations(List<Location> locations, Consumer<Location> processor) {
        if (locations == null || processor == null) {
            throw new IllegalArgumentException("Location list and filter cannot be null");
        }
        for (Location location : locations) {
            processor.accept(location);
        }
    }

    public List<Double> calculateDistances(List<Location> locations, Function<Location, Double> measurer) {
        if (locations == null || measurer == null) {
            throw new IllegalArgumentException("Location list and filter cannot be null");
        }
        List<Double> result = new ArrayList<>();
        for (Location location : locations) {
            result.add(measurer.apply(location));
        }
        return result;
    }
}
