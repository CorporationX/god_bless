package school.faang.bjs2_71405;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LocationSearchEngine {
    public List<Location> filterLocations(List<Location> locations, Predicate<Location> locationPredicate) {
        if (locations == null || locations.isEmpty()) {
            throw new IllegalArgumentException("Список локаций пуст!");
        }

        return locations.stream()
                .filter(locationPredicate)
                .toList();
    }

    public void processLocations(List<Location> locations, Consumer<Location> locationConsumer) {
        if (locations == null || locations.isEmpty()) {
            throw new IllegalArgumentException("Список локаций пуст!");
        }

        if (locationConsumer == null) {
            throw new IllegalArgumentException("Консьюмер не может быть null!");
        }

        locations.forEach(locationConsumer);
    }

    public List<Double> calculateDistances(List<Location> locations, Function<Location, Double> distanceCalculator) {
        if (locations == null || locations.isEmpty()) {
            throw new IllegalArgumentException("Список локаций пуст!");
        }

        if (distanceCalculator == null) {
            throw new IllegalArgumentException("Лямба для расчёта расстояния не может быть null!");
        }

        return locations.stream()
                .map(distanceCalculator)
                .toList();
    }
}
