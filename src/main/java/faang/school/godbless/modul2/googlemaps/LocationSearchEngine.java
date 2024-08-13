package faang.school.godbless.modul2.googlemaps;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LocationSearchEngine {
    public List<Location> filterLocations(List<Location> locations, Predicate<Location> filter) {
        return locations.stream()
                .filter(filter)
                .toList();
    }

    public void processLocations(List<Location> filteredLocations, Consumer<Location> locationConsumer) {
        filteredLocations.forEach(locationConsumer);
    }

    public List<Double> calculateDistances(List<Location> locations, Function<Location, Double> locationFunction) {
        return locations.stream()
                .map(locationFunction)
                .toList();
    }
}
