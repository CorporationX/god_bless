package faang.school.godbless.google_maps;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LocationSearchEngine {

    public List<Location> filterLocations(List<Location> locations, Predicate<Location> isCorrect) {
        return locations.stream().filter(isCorrect).collect(Collectors.toList());
    }

    public void processLocations(List<Location> locations, Consumer<Location> processor) {
        locations.forEach(processor);
    }

    public List<Double> calculateDistances(List<Location> locations, Function<Location, Double> calculate) {
        return locations.stream().map(calculate).collect(Collectors.toList());
    }
}
