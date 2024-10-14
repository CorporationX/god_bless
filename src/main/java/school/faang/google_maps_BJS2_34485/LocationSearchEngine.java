package school.faang.google_maps_BJS2_34485;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LocationSearchEngine {

    public List<Location> filterLocations(List<Location> locations, Predicate<Location> predicate) {
        return locations.stream()
                .filter(predicate)
                .toList();
    }

    public void processLocations(List<Location> locations, Consumer<Location> consumer) {
        locations.forEach(consumer);
    }

    public List<Double> calculateDistances(List<Location> locations, Function<Location, Double> distanceFunction) {
        return locations.stream()
                .map(distanceFunction)
                .toList();
    }
}
