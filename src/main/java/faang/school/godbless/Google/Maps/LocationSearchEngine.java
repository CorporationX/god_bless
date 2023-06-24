package faang.school.godbless.Google.Maps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LocationSearchEngine {
    public List<Location> filterLocations(List<Location> locationList, Predicate<Location> predicate) {
        List<Location> correctLocations = new ArrayList<>();

        for (Location location : locationList) {
            if (predicate.test(location)) {
                correctLocations.add(location);
            }
        }
        return correctLocations;
    }

    public void processLocations(List<Location> locationList, Consumer<Location> consumer) {
        for (Location location: locationList){
            consumer.accept(location);
        }
    }

    public List<Double> calculateDistances(List<Location> locationList, Function<Location, Double> function) {
        List<Double> distances = new ArrayList<>();

        for (Location location: locationList){
            distances.add(function.apply(location));
        }
        return distances;
    }

}
