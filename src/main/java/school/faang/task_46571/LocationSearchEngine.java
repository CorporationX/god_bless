package school.faang.task_46571;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LocationSearchEngine {
    public List<Location> filterLocations(List<Location> locations, Predicate<Location> predicate) {
        return locations.stream()
                .filter(predicate)
                .toList();
    }

    public void processLocations(List<Location> locations, Consumer<Location> consumer) {
        locations.forEach(consumer);
    }

    public List<Double> calculateDistances(List<Location> locations, Function<Location, Double> function) {
        List<Double> listOfDistances = new ArrayList<>();

        locations.forEach(location -> listOfDistances.add(function.apply(location)));

        return listOfDistances;
    }
}
