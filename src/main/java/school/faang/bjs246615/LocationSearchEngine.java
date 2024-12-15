package school.faang.bjs246615;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LocationSearchEngine {

    public List<Location> filterLocations(List<Location> locations, Predicate<Location> predicate) {
        List<Location> result = new ArrayList<>();
        for (Location location : locations) {
            if (predicate.test(location)) {
                result.add(location);
            }
        }
        return result;
    }

    public void processLocations(List<Location> locations, Consumer<Location> consumer) {
        for (Location location : locations) {
            consumer.accept(location);
        }
    }

    public List<Double> calculateDistances(List<Location> locations, Function<Location, Double> calculate) {
        List<Double> distances = new ArrayList<>();
        for (Location location : locations) {
            distances.add(calculate.apply(location));
        }
        return distances;
    }
}
