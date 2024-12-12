package school.faang.task_46571;

import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LocationSearchEngine {
    public List<Location> filterLocations(List<Location> locations, Predicate<Location> predicate) {
        if (CollectionUtils.isEmpty(locations) || predicate == null) {
            throw new IllegalArgumentException("Locations is empty or predicate is null!");
        }
        return locations.stream()
                .filter(predicate)
                .toList();
    }

    public void processLocations(List<Location> locations, Consumer<Location> consumer) {
        if (CollectionUtils.isEmpty(locations) || consumer == null) {
            throw new IllegalArgumentException("Locations is empty or consumer is null!");
        }
        locations.forEach(consumer);
    }

    public List<Double> calculateDistances(List<Location> locations, Function<Location, Double> function) {
        if (CollectionUtils.isEmpty(locations) || function == null) {
            throw new IllegalArgumentException("Locations is empty or function is null!");
        }

        List<Double> listOfDistances = new ArrayList<>();
        locations.forEach(location -> listOfDistances.add(function.apply(location)));

        return listOfDistances;
    }
}
