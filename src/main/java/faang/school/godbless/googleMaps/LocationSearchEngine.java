package faang.school.godbless.googleMaps;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LocationSearchEngine {
    public List<Location> filterLocations(List<Location> locations, Predicate<Location> condition) {
        return locations.stream().filter(condition).collect(Collectors.toList());
    }

    public void processLocations(List<Location> locations, Consumer<Location> function) {
        locations.forEach(function);
    }

    public List<Double> calculateDistances(List<Location> locations,
                                           Function<Location, Double> counting) {
        return locations.stream().map(counting).collect(Collectors.toList());
    }
}
