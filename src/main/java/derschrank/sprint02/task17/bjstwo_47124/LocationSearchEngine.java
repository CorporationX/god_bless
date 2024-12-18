package derschrank.sprint02.task17.bjstwo_47124;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LocationSearchEngine implements LocationSearchEngineInterface {
    @Override
    public List<Location> filterLocations(List<Location> locations, Predicate<Location> finder) {
        return locations.stream().filter(finder).toList();
    }

    @Override
    public void processLocations(List<Location> locations, Consumer<Location> actor) {
        locations.stream().peek(actor);
    }

    @Override
    public List<Double> calculateDistances(List<Location> locations, Function<Location, Double> calculator) {
        return locations.stream().map(calculator).toList();
    }
}
