package Sprint_2.BJS2_34628;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LocationSearchEngine {

    public static List<Location> filterLocations(List<Location> locations, Predicate<Location> predicate) {
        List<Location> result = new ArrayList<Location>();
        for (Location location : locations) {
            if (predicate.test(location)) {
                result.add(location);
            }
        }
        return result;
    }

    public static void processLocations(List<Location> locations, Consumer<Location> action) {
        for (Location location : locations) {
            action.accept(location);
        }
    }

    public static List<Double> calculateDistances(List<Location> locations, Function<Location, Double> distanceFunction) {
        List<Double> distances = new ArrayList<>();
        for (Location location : locations) {
            double distance = distanceFunction.apply(location);
            distances.add(distance);  // Добавляем рассчитанное расстояние
        }
        return distances;  // Возвращаем список расстояний
    }
}
