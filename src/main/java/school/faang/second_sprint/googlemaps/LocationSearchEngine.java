package school.faang.second_sprint.googlemaps;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LocationSearchEngine {
    public List<Location> filterLocation(@NonNull List<Location> locations, Predicate<Location> predicate) {
        if (locations.isEmpty()) {
            throw new IllegalArgumentException("locations List cannot be empty");
        }
        List<Location> filteredLocations = new ArrayList<>();
        for (Location location : locations) {
            if (predicate.test(location)) {
                filteredLocations.add(location);
            }
        }
        return filteredLocations;
    }

    public void processLocations(@NonNull List<Location> locations, Consumer<Location> consumer) {
        for (Location location : locations) {
            consumer.accept(location);
        }
    }

    public List<Double> calculateDistances(@NonNull List<Location> locations,
                                           Function<Location, Double> distanceLocation) {
        List<Double> distances = new ArrayList<>();
        for (Location location : locations) {
            distances.add(distanceLocation.apply(location));
        }
        return distances;
    }

    public void processDistances(@NonNull List<Double> locations, Consumer<Double> consumer) {
        for (Double location : locations) {
            consumer.accept(location);
        }
    }
}
