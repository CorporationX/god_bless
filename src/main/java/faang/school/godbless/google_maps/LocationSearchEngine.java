package faang.school.godbless.google_maps;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LocationSearchEngine {

    public List<Location> filterLocations(List<Location> locations, Predicate<Location> filter) {
        return locations.stream()
                .filter(filter)
                .toList();
    }

    public void processLocations(List<Location> locations, Consumer<Location> process) {
        locations.forEach(process);
    }

    public List<Double> calculateDistances(List<Location> locations, Function<Location, Double> function) {
        return locations.stream()
                .map(function)
                .toList();
    }
}