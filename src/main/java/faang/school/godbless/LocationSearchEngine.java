package faang.school.godbless;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LocationSearchEngine {

    public List<Location> filterLocation(List<Location> locations, Predicate<Location> locationPredicate) {
        List<Location> newLocations = new ArrayList<>();
        for (Location location : locations) {
             if (locationPredicate.test(location)) {
                 newLocations.add(location);
             }
        }
        return newLocations;
    }

    public void processLocations(List<Location> locations, Consumer<Location> locationConsumer) {
        for (Location location : locations) {
            locationConsumer.accept(location);
        }
    }

    public List<Double> calculateDistances(List<Location> locations, Function<Location, Double> locationDoubleFunction) {
        List<Double> distances = new ArrayList<>();
        for (Location location : locations) {
                distances.add(locationDoubleFunction.apply(location));
        }
        return distances;
    }
}
