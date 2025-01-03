package faang.school.godbless.SecondSprint.BJS2_46662;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LocationSearchEngine {

    public List<Location> filterLocations(List<Location> location, Predicate<Location> predicator) {

        return location.stream()
                .filter(predicator)
                .toList();
    }

    public void processLocations(List<Location> location, Consumer<Location> consumer) {
        location.stream()
                .forEach(consumer);
    }

    public List<Double> calculateDistances(List<Location> locations, Function<Location, Double> function) {

        return locations.stream()
                        .map(function)
                        .toList();
    }
}
