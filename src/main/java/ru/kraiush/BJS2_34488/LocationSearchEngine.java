package ru.kraiush.BJS2_34488;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LocationSearchEngine {

    public List<Location> filterLocations(List<Location> locations, Predicate<Location> filter) {
        List<Location> filteredLocations = new ArrayList<>();
        for (Location location : locations) {
            if (filter.test(location)) {
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

    public List<Double> calculateDistances(List<Location> locations, Function<Location, Double> calculator) {
        List<Double> distances = new ArrayList<>();
        for (Location location : locations) {
            double distance = calculator.apply(location);
            distances.add(distance);
        }
        return distances;
    }
}
