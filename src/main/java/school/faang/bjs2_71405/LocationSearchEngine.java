package school.faang.bjs2_71405;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LocationSearchEngine {
    public List<Location> filterLocations(List<Location> locations, Predicate<Location> locationPredicate) {
        validateList(locations);

        return locations.stream()
                .filter(locationPredicate)
                .toList();
    }

    public void processLocations(List<Location> locations, Consumer<Location> locationConsumer) {
        validateList(locations);

        if (locationConsumer == null) {
            throw new IllegalArgumentException("Консьюмер не может быть null!");
        }

        locations.forEach(locationConsumer);
    }

    public List<Double> calculateDistances(List<Location> locations, Function<Location, Double> distanceCalculator) {
        validateList(locations);

        if (distanceCalculator == null) {
            throw new IllegalArgumentException("Лямба для расчёта расстояния не может быть null!");
        }

        return locations.stream()
                .map(distanceCalculator)
                .toList();
    }

    private <T> void validateList(List<T> list) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("Список локаций пуст!");
        }
    }
}
