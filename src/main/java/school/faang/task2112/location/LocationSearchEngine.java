package school.faang.task2112.location;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LocationSearchEngine {
    public static List<Location> filterLocations(List<Location> locations, Predicate<Location> predicate) {
        return locations.stream()
                .filter(predicate::test).
                toList();
    }

    public static void processLocations(List<Location> locations, Consumer<Location> consumer) {
        locations.stream().peek(consumer::accept).toList();
    }

    public static List<Double> calculateDistances(List<Location> locations, Location targetLocation, Function<Location, Double> function) {
        return locations.stream().map(function::apply).toList();
    }
}
