package GoogleMaps;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LocationSearchEngine {
    public List<Location> filterLocations(List<Location> locationList, Predicate<Location> condition){
        List<Location> filteredLocations = new ArrayList<>();

        for (Location location : locationList) {
            if (condition.test(location)) {
                filteredLocations.add(location);
            }
        }

        return filteredLocations;
    }

    public void processLocations(List<Location> filteredLocationList, Consumer<Location> consumer){
        consumer = name -> System.out.println(name);
        filteredLocationList.forEach(consumer);
    }

    public List<Double> calculateDistances(List<Location> locationList, Function<Location, Double> function){
        List<Double> calculatedDistances = new ArrayList<>();

        for (Location location : locationList) {
            double distance = function.apply(location);
            calculatedDistances.add(distance);
        }

        return calculatedDistances;
    }
}
