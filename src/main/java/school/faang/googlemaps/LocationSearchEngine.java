package school.faang.googlemaps;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LocationSearchEngine {

    public List<Location> filterLocations(@NonNull List<Location> locations, Predicate<Location> filter) {
        return locations.stream()
                .filter(filter)
                .toList();

    }

    public void processLocations(@NonNull List<Location> locations, Consumer<Location> consumer) {
        for (Location location : locations) {
            consumer.accept(location);
        }
    }

    public List<Double> calculateDistances(List<Location> locations, Function<Location, Double> function) {
        List<Double> distances = new ArrayList<>();
        for (Location location : locations) {
            distances.add(function.apply(location));
        }
        return distances;
    }

}
