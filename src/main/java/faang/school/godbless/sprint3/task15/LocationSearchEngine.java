package faang.school.godbless.sprint3.task15;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LocationSearchEngine {

    public List<Location> filterLocations(List<Location> locations, Predicate<Location> predicate) {
        if (locations == null || predicate == null) {
            throw new IllegalArgumentException();
        }

        locations.removeIf(predicate);
        return locations;
    }

    public void processLocations(List<Location> locations, Consumer<Location> consumer) {
        locations.forEach(consumer);
    }

    public List<Double> calculateDistances(List<Location> locations, Function<Location, Double> function) {
        List<Double> distances = new ArrayList<>();
        for (Location location : locations) {
            distances.add(function.apply(location));
        }
        return distances;
    }
}
