package faang.school.godbless.sprint3.GoogleMaps;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LocationSearchEngine {
    public List<Location> filterLocations(List<Location> list, Predicate<Location> predicate) {
        List<Location> result = new ArrayList<>();
        for (Location location : list) {
            if (predicate.test(location)) {
                result.add(location);
            }
        }
        return result;
    }

    public void processLocations(List<Location> list, Consumer<Location> consumer) {
        for (Location location : list) {
            consumer.accept(location);
        }
    }

    public List<Double> calculateDistances(List<Location> list, Function<Location, Double> function) {
        List<Double> result = new ArrayList<>();
        for (Location location : list) {
            result.add(function.apply(location));
        }
        return result;
    }
}
