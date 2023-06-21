package faang.school.godbless.GoogleMaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LocationSearchEngine {
    public static void main(String[] args) {
        List<Location> locations = new ArrayList<>(Arrays.asList(
                new Location("Eiffel Tower", 48.8584, 2.2945),
                new Location("Statue of Liberty", 40.6892, -74.0445),
                new Location("Great Wall of China", 40.4319, 116.5704)
        ));

        LocationSearchEngine searchEngine = new LocationSearchEngine();

// Фильтруем местоположения по долготе
        List<Location> filteredLocations = searchEngine.filterLocations(locations, (location) -> location.longitude() > 0);

// Выводим названия отфильтрованных местоположений
        searchEngine.processLocations(filteredLocations, (location) -> System.out.println(location.name()));

// Вычисляем расстояния от заданной точки до каждого местоположения
        double baseLatitude = 37.4220;
        double baseLongitude = -122.0841;
        List<Double> distances = searchEngine.calculateDistances(locations, (location) -> {
            double latitudeDiff = Math.abs(location.latitude() - baseLatitude);
            double longitudeDiff = Math.abs(location.longitude() - baseLongitude);
            return Math.sqrt(Math.pow(latitudeDiff, 2) + Math.pow(longitudeDiff, 2));
        });

        distances.forEach(System.out::println);
    }

    public List<Double> calculateDistances(List<Location> locations, Function<Location,Double> function) {
        List<Double> distances = new ArrayList<>();
        locations.forEach(location -> distances.add(function.apply(location)));
        return distances;
    }

    public void processLocations(List<Location> filteredLocations, Consumer<Location> consumer) {
        filteredLocations.forEach(consumer);
    }

    public List<Location> filterLocations(List<Location> locations, Predicate<Location> condition) {
        List<Location> filteredLocations = new ArrayList<>();
        locations.forEach(location -> {
            if (condition.test(location)){
                filteredLocations.add(location);
            }
        });
        return filteredLocations;
    }

}
