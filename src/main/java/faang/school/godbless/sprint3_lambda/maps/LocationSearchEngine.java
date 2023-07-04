package main.java.faang.school.godbless.sprint3_lambda.maps;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LocationSearchEngine {
    public static List<Location> filterLocations(List<Location> location, Predicate<Location> predicate) {
        List<Location> locations = new ArrayList<>();

        for (Location location1 : location) {
            if (predicate.test(location1)) {
                locations.add(location1);
            }
        }
        return locations;
    }

    public static void processLocations(List<Location> location, Consumer<Location> consumer) {
        for (Location location2 : location) {
            consumer.accept(location2);
        }
    }

    public static List<Double> calculateDistances(List<Location> location, Function<Location, Double> function) {
        List<Double> distance = new ArrayList<>();

        for (Location location3 : location) {
            double distances = function.apply(location3);
            distance.add(distances);
        }
        return distance;
    }
}
