package Google_Maps;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LocationSearchEngine {
    public List<Location> filterLocations(List<Location> locations,
                                          Predicate<Location> filterCondition) {
        List<Location> filteredLocations = new ArrayList<>();
        for (Location location : locations){
            if (filterCondition.test(location)){
                filteredLocations.add(location);
            }
        }
        return filteredLocations;
    }

    public void processLocations(List<Location> locations,
                                 Consumer<Location> process){
        for (Location location: locations){
            process.accept(location);
        }
    }

    public List<Double> calculateDistances(List<Location> locations,
                                           Function<Location,Double> calculation){
        List<Double> distances = new ArrayList<>();
        for (Location location: locations){
            Double distance = calculation.apply(location);
            distances.add(distance);
        }
        return distances;
    }
}
