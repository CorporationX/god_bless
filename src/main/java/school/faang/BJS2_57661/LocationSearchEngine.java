package school.faang.BJS2_57661;

import lombok.NonNull;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LocationSearchEngine {
    public List<Location> filterLocations(@NonNull List<Location> locations,
                                          @NonNull Predicate<Location> filter) {
        if (locations.isEmpty()) {
            throw new IllegalArgumentException("No locations found");
        }
        return locations.stream()
                .filter(filter)
                .toList();
    }

    public void processLocations(@NonNull List<Location> locations,
                                 @NonNull Consumer<Location> process) {
        for (Location location : locations) {
            process.accept(location);
        }
    }

    public List<Double> calculateDistances(@NonNull List<Location> locations,
                                           @NonNull Function<Location, Double> function) {
        if (locations.isEmpty()) {
            throw new IllegalArgumentException("No locations found");
        }
        return locations.stream()
                .map(function)
                .toList();
    }
}
