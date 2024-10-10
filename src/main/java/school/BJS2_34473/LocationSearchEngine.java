package school.BJS2_34473;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LocationSearchEngine {

    public List<Location> filterLocations(List<Location> list, Predicate<Location> filter) {
        return list.stream().filter(filter).toList();
    }

    public void processLocations(List<Location> list, Consumer<Location> consumer) {
        list.forEach(consumer);
    }

    public List<Double> calculateDistances(List<Location> list, Function<Location, Double> distanceFunction) {
        return list.stream().map(distanceFunction::apply).toList();
    }

}
