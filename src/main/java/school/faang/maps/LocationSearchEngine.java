package school.faang.maps;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author Danil Pudovkin
 * @since 11.06.2025
 */
public class LocationSearchEngine {

    public List<Location> filterLocations(List<Location> locations, Predicate<Location> filter) {
        return locations.stream()
                .filter(filter)
                .toList();
    }

    public void processLocations(List<Location> locations, Consumer<Location> handler) {
        locations.forEach(handler);
    }

    public List<Double> calculateDistances(List<Location> locations, Function<Location, Double> distanceCalculator) {
        return locations.stream()
                .map(distanceCalculator)
                .toList();
    }
}
