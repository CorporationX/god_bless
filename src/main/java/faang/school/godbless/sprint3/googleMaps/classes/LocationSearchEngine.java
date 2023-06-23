package faang.school.godbless.sprint3.googleMaps.classes;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LocationSearchEngine {

    public static List<Location> filterLocation(List<Location> list, Predicate<Location> predicate) {
        List<Location> resultList = new ArrayList<>();
        for (Location location : list) {
            if (predicate.test(location)) {
                resultList.add(location);
            }
        }
        return resultList;
    }

    public static void processLocation(List<Location> list, Consumer<Location> consumer) {
        for (Location location : list) {
            consumer.accept(location);
        }
    }

    public static List<Double> calculateDistance(List<Location> list, Function<Location, Double> function) {
        List<Double> distanceList = new ArrayList<>();
        for (Location location : list) {
            distanceList.add(function.apply(location));
        }
        return distanceList;
    }
}