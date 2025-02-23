package school.faang.googlemaps;

import lombok.NonNull;

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
        locations.forEach(consumer);
    }

    public List<Double> calculateDistances(@NonNull List<Location> locations, Function<Location, Double> function) {

        return locations.stream()
                .map(function)
                .toList();
    }
}
