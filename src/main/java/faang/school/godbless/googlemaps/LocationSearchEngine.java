package faang.school.godbless.googlemaps;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LocationSearchEngine {
    public List<Location> filterLocations(List<Location> locations, Predicate<Location> filter) {
        return locations.stream().filter(filter).toList();
    }
    public void processLocations(List<Location> locations, Consumer<Location> handler) {
        locations.forEach(handler);
    }
    public List<Double> calculateDistances(List<Location> locations, Function<Location, Double> func) {
        List<Double> res = new ArrayList<>();
        locations.forEach((el)->{
            res.add(func.apply(el));
        });
        return res;
    }
}
