package school.faang.bjs2_70040;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LocationSearchEngine {
    public List<Location> filterLocations(List<Location> locations, Predicate<Location> predicate) {
        List<Location> filteredLocations = new ArrayList<>();
        for (Location location : locations) {
            if (predicate.test(location)) {
                filteredLocations.add(location);
            }
        }
        return filteredLocations;
    }

    public void processLocations(List<Location> locations, Consumer<Location> consumer) {
        for (Location location : locations) {
            consumer.accept(location);
        }
    }

    public List<Double> calculateDistances(List<Location> locations, Function<Location, Double> function) {
        List<Double> distances = new ArrayList<>();
        for (Location location : locations) {
            distances.add(function.apply(location));
        }
        return distances;
    }
}
