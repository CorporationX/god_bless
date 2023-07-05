package faang.school.godbless;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LocationSearchEngine {
    public List<Location> filterLocations(List<Location> locationList, Predicate<Location> condition){
        checkLocations(locationList);
        List<Location> filtered = new ArrayList<>();
        for(Location location: locationList){
            if (condition.test(location)){
                filtered.add(location);
            }
        }
        return filtered;
    }

    public void processLocations(List<Location> locationList, Consumer<Location> consumer){
        checkLocations(locationList);
        for(Location location: locationList){
            consumer.accept(location);
        }
    }

    public List<Double> calculateDistances (List<Location> locationList, Function<Location, Double> function){
        checkLocations(locationList);
        List<Double> calculated = new ArrayList<>();
        for (Location location: locationList){
            calculated.add(function.apply(location));
        }
        return calculated;
    }

    private static void checkLocations(List<Location> locations) {
        if (locations.isEmpty()) {
            throw new IllegalArgumentException("Locations is empty");
        }
    }
}
