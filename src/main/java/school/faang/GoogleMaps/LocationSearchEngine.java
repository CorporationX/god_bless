package school.faang.GoogleMaps;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LocationSearchEngine {

    public List<Location> filterLocations(List<Location> locationList, Predicate<Location> predicate) {
        return locationList.stream().filter(predicate).toList();
    }

    public void processLocations(List<Location> locationList, Consumer<Location> consumer) {
        locationList.forEach(consumer);
    }

    public List<Double> calculateDistances(List<Location> locationList, Function<Location, Double> function) {
        return locationList.stream().map(function).toList();
    }
}
