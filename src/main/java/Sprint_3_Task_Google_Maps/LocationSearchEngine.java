package Sprint_3_Task_Google_Maps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LocationSearchEngine {

    public List<Location> filterLocations(List<Location> locations, Predicate<Location> filter) {
        List<Location> filteredLocations = new ArrayList<>();
        for (Location location : locations) {
            if (filter.test(location)) {
                filteredLocations.add(location);
            }
        }
        return filteredLocations;
    }

    public void processLocations(List<Location> filteredLocations, Consumer<Location> handling) {
        //List<Location> processedLocations = new ArrayList<>();
        for (Location filteredLocation : filteredLocations) {
            handling.accept(filteredLocation);
            //не надо ничего возвращать от Consumer. void
            //метод ведь просто делает это:
            //searchEngine.processLocations(filteredLocations, (location) -> System.out.println(location.getName()));
            //Consumer только вбирает в себя значение. void accept(T t);. Молча забирает значение и сидит с ним, любуется.
            //а потом, через лямбду уже говорим, что будем делать с этим взятым значением.
        }
    }

    public List<Double> calculateDistances(List<Location> filteredLocations, Function<Location, Double> distanceCalculator) {
        List<Double> distances = new ArrayList<>();
        for (Location processedLocation : filteredLocations) {
            distances.add(distanceCalculator.apply(processedLocation));
        }
        return distances;
    }

    public static void main(String[] args) {

        List<Location> locations = new ArrayList<>(Arrays.asList(
                new Location("Eiffel Tower", 48.8584, 2.2945),
                new Location("Statue of Liberty", 40.6892, -74.0445),
                new Location("Great Wall of China", 40.4319, 116.5704)
        ));

        LocationSearchEngine searchEngine = new LocationSearchEngine();

// Фильтруем местоположения по долготе
        List<Location> filteredLocations = searchEngine.filterLocations(locations, (location) -> location.getLongitude() > 0);

// Выводим названия отфильтрованных местоположений
        searchEngine.processLocations(filteredLocations, (location) -> System.out.println(location.getName()));

// Вычисляем расстояния от заданной точки до каждого местоположения
        double baseLatitude = 37.4220;
        double baseLongitude = -122.0841;
        List<Double> distances = searchEngine.calculateDistances(locations, (location) -> {
            double latitudeDiff = Math.abs(location.getLatitude() - baseLatitude);
            double longitudeDiff = Math.abs(location.getLongitude() - baseLongitude);
            return Math.sqrt(Math.pow(latitudeDiff, 2) + Math.pow(longitudeDiff, 2));
        });

        System.out.println(distances);
    }
}
