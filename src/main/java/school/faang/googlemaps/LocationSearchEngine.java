package school.faang.googlemaps;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LocationSearchEngine {

    public List<Location> filterLocations(List<Location> locations, Predicate<Location> predicate) {
        return locations.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }

    public void processLocations(List<Location> filteredLocations, Consumer<Location> consumer) {
        for (Location location : filteredLocations) {
            consumer.accept(location);
        }
    }

    public List<Double> calculateDistances(List<Location> locations, Function<Location, Double> distanceFunction) {
        return locations.stream()
                .map(distanceFunction)
                .collect(Collectors.toList());
    }
}
