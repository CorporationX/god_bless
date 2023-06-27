package faang.school.godbless.GoogleMaps;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LocationSearchEngine {
    public List<Location> filterLocations(List<Location> locationList, Predicate<Location> locationPredicate){
        return locationList.stream().filter(locationPredicate).toList();
    }

    public void processLocations(List<Location> locationList, Consumer<Location> locationConsumer){
        locationList.forEach(locationConsumer);
    }

    public List<Double> calculateDistances(List<Location> locationList, Function<Location, Double> function){
        return locationList.stream().map(function).toList();
    }
}
