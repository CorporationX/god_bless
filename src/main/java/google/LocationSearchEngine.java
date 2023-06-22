package google;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LocationSearchEngine {
    public List<Location> filterLocations(List<Location> locations, Predicate<Location> condition) {
        List<Location> filteredLocations = new ArrayList<>();
        for (Location location : locations) {
            if (condition.test(location)) {
                filteredLocations.add(location);
            }
        }
        return filteredLocations;
    }

    public void processLocations(List<Location> locations, Consumer<Location> action) {
        for (Location location : locations) {
            action.accept(location);
        }
    }

    public List<Double> calculateDistances(List<Location> locations, Function<Location, Double> operation) {
        List<Double> distances = new ArrayList<>();
        for (Location location : locations) {
            distances.add(operation.apply(location));
        }
        return distances;
    }
}
