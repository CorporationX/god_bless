package faang.school.godbless.fi.gmaps;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LocationSearchEngine {

    public List<Location> filterLocations(List<Location> locations,
                                          Predicate<Location> filter) {

        return locations.stream().filter(filter).toList();
    }

    public void processLocations(List<Location> locations,
                                 Consumer<Location> processor) {

        locations.forEach(processor);
    }

    public List<Double> calculateDistances(List<Location> locations,
                                           Function<Location, Double> calculator) {

        return locations.stream().map(calculator).toList();
    }

}
