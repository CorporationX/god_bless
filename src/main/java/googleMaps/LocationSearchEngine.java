package googleMaps;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LocationSearchEngine {
    public List<Location> filterLocations(List<Location> locations, Predicate<Location> filterLocations){
        return locations.stream()
                .filter(filterLocations)
                .collect(Collectors.toList());
    }

    public void processLocations(List<Location> locations, Consumer<Location> processLocations){
        locations.forEach(processLocations);
    }

    public List<Double> calculateDistances(List<Location> locations, Function<Location, Double> calculateDistances){
        return locations.stream()
                .map(calculateDistances)
                .collect(Collectors.toList());
    }
}
