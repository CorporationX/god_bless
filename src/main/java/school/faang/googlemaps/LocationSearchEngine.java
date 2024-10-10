package school.faang.googlemaps;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LocationSearchEngine {
    public List<Location> filterLocations(List<Location> locations, Predicate<Location> locationFilter) {
        return locations.stream().filter(locationFilter).toList();
    }

    public void processLocations(List<Location> locations, Consumer<Location> locationProcessor) {
        locations.forEach(locationProcessor);
    }

    public List<Double> calculateDistances(List<Location> locations, Function<Location, Double> distanceCalculator) {
        List<Double> distances = new ArrayList<>();
        for (Location location : locations) {
            distances.add(distanceCalculator.apply(location));
        }
        return distances;
    }
}
