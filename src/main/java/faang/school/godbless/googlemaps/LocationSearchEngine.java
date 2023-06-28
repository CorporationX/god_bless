package faang.school.godbless.googlemaps;

import ch.qos.logback.classic.pattern.ClassOfCallerConverter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LocationSearchEngine {
    public List<Location> filterLocations(List<Location> locations, Predicate<Location> predicate) {
        List<Location> filteredLocations = new ArrayList<>();
        for (Location item : locations) {
            if (predicate.test(item)) {
                filteredLocations.add(item);
            }
        }
        return filteredLocations;
    }

    public void processLocation(List<Location> locations, Consumer<Location> consumer) {
        for (Location item : locations) {
            consumer.accept(item);
        }
    }

    public List<Double> calculateDistances(List<Location> locations, Function<Location, Double> distance) {
        List<Double> distances = new ArrayList<>();
        for (Location item : locations) {
            distances.add(distance.apply(item));
        }
        return distances;
    }

}
