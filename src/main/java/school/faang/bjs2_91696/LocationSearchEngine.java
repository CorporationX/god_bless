package school.faang.bjs2_91696;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

@AllArgsConstructor
public class LocationSearchEngine {

    public List<Location> filterLocations(List<Location> locations, Predicate<Location> predicate) {
        return locations.stream()
                .filter(predicate::test)
                .toList();
    }

    public void processLocations(List<Location> locations, Consumer<Location> processor) {
        locations.stream()
                .forEach(processor);
    }

    public List<Double> calculateDistances(List<Location> locations, Function<Location, Double> calculator) {
        return locations.stream()
                .map(calculator)
                .toList();
    }
}
