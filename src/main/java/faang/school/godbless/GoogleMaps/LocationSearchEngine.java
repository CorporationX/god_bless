package faang.school.godbless.GoogleMaps;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LocationSearchEngine {

    public List<Location> filterLocations(List<Location> locations, Predicate<Location> filter) {
        List<Location> filteredLocations = new ArrayList<>();
        locations.forEach(location -> {
            if (filter.test(location)) {
                filteredLocations.add(location);
            }
        });
        return filteredLocations;
    }

    public void processLocations(List<Location> locations, Consumer<Location> consumer) {
        locations.forEach(consumer);
    }

    public List<Double> calculateDistances(List<Location> locations, Function<Location, Double> distanceFunction) {
        List<Double> distances = new ArrayList<>();
        locations.forEach(location -> distances.add(distanceFunction.apply(location)));
        return distances;
    }
}
