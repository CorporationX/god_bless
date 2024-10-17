package school.faang.BJS2_34579_GoogleMaps;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LocationSearchEngine {
    public List<Location> filterLocations(List<Location> locations, Predicate<Location> locationFilter) {
        return locations.stream()
                .filter(locationFilter)
                .toList();
    }

    public void processLocations(List<Location> locations, Consumer<Location> locationConsumer) {
        locations.forEach(locationConsumer);
    }

    public List<Double> calculateDistances(List<Location> locations, Function<Location, Double> locationMapper) {
        return locations.stream()
                .map(locationMapper)
                .toList();
    }
}
