package school.faang.maps;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LocationSearchEngine {
    public List<Location> filterLocations(List<Location> locations, Predicate<Location> locationPredicate) {
        List<Location> filteredLocations = new ArrayList<>();

        for (Location location : locations) {
            if (locationPredicate.test(location)) {
                filteredLocations.add(location);
            }
        }
        return filteredLocations;
    }

    public void processLocations(List<Location> locations, Consumer<Location> locationConsumer) {
        for (Location location : locations) {
            locationConsumer.accept(location);
        }
    }

    public List<Double> calculateDistances(List<Location> locations, Function<Location, Double> distanceFunction) {
        List<Double> distances = new ArrayList<>();

        for (Location location : locations) {
            distances.add(distanceFunction.apply(location));
        }
        return distances;
    }
}
