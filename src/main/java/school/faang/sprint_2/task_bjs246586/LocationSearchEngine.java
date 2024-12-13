package school.faang.sprint_2.task_bjs246586;

import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LocationSearchEngine {

    public List<Location> filterLocations(List<Location> locations, Predicate<Location> locationFilter) {
        if (locations == null || locations.isEmpty()) {
            return Collections.emptyList();
        }
        return locations.stream()
                .filter(locationFilter)
                .toList();
    }

    public void processLocations(List<Location> locations, Consumer<Location> action) {
        if (locations == null || locations.isEmpty()) {
            return;
        }
        locations.forEach(action);
    }

    public List<Double> calculateDistances(List<Location> locations, Function<Location, Double> function) {
        if (locations == null || locations.isEmpty()) {
            return Collections.emptyList();
        }
        return locations.stream()
                .map(function)
                .toList();
    }
}
