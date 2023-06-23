package faang.school.godbless;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LocationSearchEngine {
    public List<Location> filterLocations(List<Location> locations, Predicate<Location> checker){
        return locations.stream().filter(checker).toList();
    }

    public void processLocations(List<Location> locations, Consumer<Location> consumer) {
        locations.forEach(consumer);
    }
    public List<Double> calculateDistances(List<Location> locations, Function<Location, Double> function) {
        return locations.stream()
                .map(function)
                .toList();
    }
}
