package school.faang.googlemaps;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LocationSearchEngine {
    public List<Location> filterLocations(List<Location> locationList, Predicate<Location> predicate)  {
        List<Location> locations = new ArrayList<>();
        for (Location location : locationList) {
            if (predicate.test(location)) {
                locations.add(location);
            }
        }
        return locations;
    }

    public void processLocations(List<Location> locationList, Consumer<Location> consumer) {
        for (Location location : locationList) {
            consumer.accept(location);
        }
    }

    public List<Double> calculateDistances(List<Location> locationList, Function<Location, Double> function) {
        List<Double> doubleList = new ArrayList<>();
        for (Location location : locationList) {
            doubleList.add(function.apply(location));
        }
        return doubleList;
    }
}
