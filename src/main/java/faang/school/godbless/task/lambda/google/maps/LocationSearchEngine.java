package faang.school.godbless.task.lambda.google.maps;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LocationSearchEngine {

    public List<Location> filterLocations(List<Location> locations,
                                          Predicate<Location> predicate) {
        return locations.stream().filter(location ->
                predicate.test(location)).collect(Collectors.toList());
    }

    public void processLocations(List<Location> locations,
                                 Consumer<Location> consumer) {
        locations.forEach(location -> consumer.accept(location));
    }

    public List<Double> calculateDistances(List<Location> locations,
                                           Function<Location, Double> function) {
        return locations.stream()
                .map(location -> function.apply(location))
                .collect(Collectors.toList());
    }
}
