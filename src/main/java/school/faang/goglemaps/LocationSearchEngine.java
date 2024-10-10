package school.faang.goglemaps;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LocationSearchEngine {

    public static List<Location> filterLocations(List<Location> locations,
                                                 Predicate<Location> predicate) {
        return locations.stream().filter(predicate).toList();
    }

    public static List<Double> calculateDistances(List<Location> locations,
                                                  Function<Location,
                                                          Double> function) {
        return locations.stream().map(function).toList();
    }

    public static void processLocations(List<Location> locations,
                                        Consumer<Location> consumer) {
        locations.forEach(consumer);
    }
}
