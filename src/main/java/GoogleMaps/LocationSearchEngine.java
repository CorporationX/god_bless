package GoogleMaps;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LocationSearchEngine {
    public List<Location> filterLocations(List<Location> locations, Predicate<Location> predicate){
        return locations.stream().filter(predicate).toList();
    }

    public void processLocations(List<Location> locationList, Consumer<Location> consumer){
        locationList.forEach(consumer);
    }

    public List<Double> calculateDistances(List<Location> location, Function<Location, Double> function){
        return location.stream().map(function).toList();
    }
}
