package faang.school.godbless.sprint3.lambda.task15;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LocationSearchEngine {

    public List<Location> filterLocations(List<Location> locations, Predicate<Location> predicate) {
        if (locations == null || predicate == null) {
            throw new IllegalArgumentException("Параметры метода не могут быть null!");
        }
        return locations.stream()
                .filter(predicate)
                .toList();
    }

    public void processLocations(List<Location> locations, Consumer<Location> consumer) {
        if (locations == null || consumer == null) {
            throw new IllegalArgumentException("Параметры метода не могут быть null!");
        }
        locations.forEach(consumer);
    }

    public List<Double> calculateDistances(List<Location> locations, Function<Location, Double> function) {
        if (locations == null || function == null) {
            throw new IllegalArgumentException("Параметры метода не могут быть null!");
        }
        List<Double> distances = new ArrayList<>();
        for (Location location : locations) {
            if (location == null) {
                throw new IllegalArgumentException("Location метода не могут быть null!");
            }
            distances.add(function.apply(location));
        }
        return distances;
    }
}
