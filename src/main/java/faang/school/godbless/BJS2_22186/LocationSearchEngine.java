package faang.school.godbless.BJS2_22186;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LocationSearchEngine {

    public List<Location> filterLocations(List<Location> locations, Predicate<Location> predicate) {
        locations.removeIf(location -> !predicate.test(location));
        return locations;
    }

    public void processLocations(List<Location> locations, Consumer<Location> consumer) {
        locations.forEach(consumer);
    }

    public List<Double> calculateDistances(List<Location> locations, Function<Location, Double> function){
        List<Double> distances = new ArrayList<>();
        locations.forEach(location -> distances.add(function.apply(location)));
        return distances;
    }

}
