package school.faang.task_60008;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LocationSearchEngine {
    public LinkedList<Location> filterLocations(LinkedList<Location> locations, Predicate<Location> condition) {
        locations.removeIf(location -> !condition.test(location));
        return locations;
    }

    public void processLocations(List<Location> locations, Consumer<Location> action) {
        for (Location location : locations) {
            action.accept(location);
        }
    }

    public LinkedList<Double> calculateDistances(List<Location> locations, Function<Location, Double> process) {
        LinkedList<Double> distances = new LinkedList<>();
        for (Location location : locations) {
            distances.add(process.apply(location));
        }
        return distances;
    }
}
