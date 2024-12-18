package derschrank.sprint02.task17.bjstwo_47124;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public interface LocationSearchEngineInterface {
    List<Location> filterLocations(List<Location> locations, Predicate<Location> finder);

    void processLocations(List<Location> locations, Consumer<Location> actor);

    List<Double> calculateDistances(List<Location> locations, Function<Location, Double> calculator);
}
