package faang.school.godbless.GoogleMaps;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LocationSearchEngine {
    public List<Location> filterLocations(List<Location> locations, Predicate<Location> filter) {
        return locations.stream().filter(filter).collect(Collectors.toList());
    }

    public void processLocations(List<Location> locations, Consumer<Location> action) {
        locations.forEach(action);
    }

    public List<Double> calculateDistances(List<Location> locations, Function<Location, Double> distanceCalculator) {
        return locations.stream().map(distanceCalculator).collect(Collectors.toList());
    }
}
