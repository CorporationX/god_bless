package school.faang.bjs2_80377;

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

    public void processLocations(List<Location> locations, Consumer<Location> process) {
        locations.forEach(process);
    }

    public List<Double> calculateDistances(List<Location> locations, Function<Location, Double> distanceCalculator) {
        return locations.stream()
                .map(distanceCalculator)
                .toList();
    }
}
