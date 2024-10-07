package school.BJS2_34473;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LocationSearchEngine {

    public List<Location> filterLocations(List<Location> list, Predicate<Location> filter) {
        List<Location> result = new ArrayList<>();
        list.stream().filter(filter).forEach(result::add);
        return result;
    }

    public void processLocations(List<Location> list, Consumer<Location> consumer) {
        list.forEach(consumer);
    }

    public List<Double> calculateDistances(List<Location> list, Function<Location, Double> distanceFunction) {
        List<Double> result = new ArrayList<>();
        for (Location location : list) {
            double distance = distanceFunction.apply(location);
            result.add(distance);
        }
        return result;
    }

}
