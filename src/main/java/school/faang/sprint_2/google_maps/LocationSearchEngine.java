package school.faang.sprint_2.google_maps;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LocationSearchEngine {
    public List<Location> filterLocations(List<Location> locations, Predicate<Location> predicate) {
        return locations.stream().filter(predicate).toList();
    }

    public void processLocations(List<Location> locations, Consumer<Location> consumer) {
        locations.forEach(consumer::accept);
    }

    public List<Double> calculateLocations(List<Location> locations, Function<Location, Double> function) {
        return locations.stream().map(function).toList();
    }
}
