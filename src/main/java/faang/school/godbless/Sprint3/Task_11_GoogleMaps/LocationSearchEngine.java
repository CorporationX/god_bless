package faang.school.godbless.Sprint3.Task_11_GoogleMaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Consumer;

public class LocationSearchEngine {

    public static List<Location> filterLocations (List<Location> locations, Predicate<Location> predicate) {
        return locations.stream().filter(predicate).toList();
    }

    public void processLocations (List<Location> locations, Consumer<Location> consumer) {
        locations.stream().forEach(consumer);
    }

    public static List<Double> calculateDistances (List<Location> locations, Function<Location, Double> function) {
        return locations.stream().map(function).toList();
    }

    public static void main(String[] args) {
        List<Location> locations = new ArrayList<>(Arrays.asList(
                new Location("Eiffel Tower", 48.8584, 2.2945),
                new Location("Statue of Liberty", 40.6892, -74.0445),
                new Location("Great Wall of China", 40.4319, 116.5704)
        ));

        LocationSearchEngine searchEngine = new LocationSearchEngine();

        // Фильтруем местоположения по долготе
        List<Location> filteredLocations = searchEngine.filterLocations(locations, (location) -> location.getLongitude() < 0);

        // Выводим названия отфильтрованных местоположений
        searchEngine.processLocations(filteredLocations, (location) -> System.out.println(location.getName()));

        // Вычисляем расстояния от заданной точки до каждого местоположения
        double baseLatitude = 57.4220;
        double baseLongitude = -112.0841;
        List<Double> distances = searchEngine.calculateDistances(locations, (location) -> {
            double latitudeDiff = Math.abs(location.getLatitude() - baseLatitude);
            double longitudeDiff = Math.abs(location.getLongitude() - baseLongitude);
            return Math.sqrt(Math.pow(latitudeDiff, 2) + Math.pow(longitudeDiff, 2));
        });
        System.out.println(distances);
    }
}
