package school.faang.task_46596;

import lombok.NonNull;

import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LocationSearchEngine {
    public List<Location> filterLocations(@NonNull List<Location> locations, @NonNull Predicate<Location> predicate) {
        return locations.stream()
                .filter(location -> location != null && predicate.test(location))
                .collect(Collectors.toList());
    }

    public void processLocations(@NonNull List<Location> locations, @NonNull Consumer<Location> consumer) {
        locations.stream()
                .filter(Objects::nonNull)
                .forEach(consumer);
    }

    public List<Double> calculateDistances(@NonNull List<Location> locations,
                                           @NonNull Function<Location, Double> distanceFunction) {
        return locations.stream()
                .filter(Objects::nonNull)
                .map(distanceFunction)
                .collect(Collectors.toList());
    }

}
