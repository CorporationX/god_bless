package school.faang.google.maps;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LocationSearchEngine {
    public static List<Location> filterLocations(List<Location> locations, Predicate<Location> filterLocation) {
        return locations.stream()
                .filter(filterLocation)
                .collect(Collectors.toList());
    }

    public static void processLocations(List<Location> locations, Consumer<Location> actionLocation) {
        locations.forEach(actionLocation);
    }

    public static List<Double> calculateDistances(List<Location> locations, Function<Location, Double> calculate) {
        return locations.stream()
                .map(calculate)
                .collect(Collectors.toList());
    }
}
