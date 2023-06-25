package faang.school.godbless.Sprint_3.GoogleMaps;

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

    public List<Double> calculateDistances(List<Location> locations, Function<Location, Double> function) {
        List<Double> result = new ArrayList<>();
        for (Location location : locations) {
            result.add(function.apply(location));
        }
        return result;
    }
}
