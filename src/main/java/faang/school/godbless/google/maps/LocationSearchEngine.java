package faang.school.godbless.google.maps;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LocationSearchEngine {

    public List<Location> filterLocations(List<Location> locations, Predicate<Location> location) {
        return locations.stream()
            .filter(location)
            .collect(Collectors.toList());
    }

    public void processLocations(List<Location> locations, Consumer<Location> location) {
        locations.forEach(location);
    }

    public List<Double> calculateDistances(List<Location> locations, Function<Location, Double> distance) {
        return locations.stream()
            .map(distance)
            .collect(Collectors.toList());
    }
}
