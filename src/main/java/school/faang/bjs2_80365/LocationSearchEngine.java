package school.faang.bjs2_80365;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LocationSearchEngine {

    public List<Location> filterLocations(List<Location> locations, Predicate<Location> filter) {
        if (locations == null) {
            throw new IllegalArgumentException("Список локаций не может быть null");
        }
        return locations.stream().filter(filter).toList();
    }

    public void processLocations(List<Location> locations, Consumer<Location> handler) {
        if (locations == null) {
            throw new IllegalArgumentException("Список локаций не может быть null");
        }
        locations.forEach(handler);
    }

    public List<Double> calculateDistances(List<Location> locations, Function<Location, Double> calculator) {
        if (locations == null) {
            throw new IllegalArgumentException("Список локаций не может быть null");
        }
        List<Double> distances = new ArrayList<>();
        locations.forEach(location -> {
            distances.add(calculator.apply(location));
        });
        return distances;
    }
}
