package googleMaps;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LocationSearchEngine {
    public List<Location> filterLocations(List<Location> locations, Predicate<Location> filter) {
        List<Location> satisfyingLoc = new ArrayList<>();
        locations.forEach(location -> {
            if (filter.test(location)) {
                satisfyingLoc.add(location);
            }
        });
    return satisfyingLoc;
    }

    public void processLocations(List<Location> locations, Consumer<Location> consumer) {
        locations.forEach(location -> consumer.accept(location));
    }

    public List<Double> calculateDistances(List<Location> locations, Function<Location, Double> functionForCalculate) {
        List<Double> distances = new ArrayList<>();
        locations.forEach(location -> {
            distances.add(functionForCalculate.apply(location));
        });
        return distances;
    }
}
