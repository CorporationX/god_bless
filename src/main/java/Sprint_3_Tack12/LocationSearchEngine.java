package Sprint_3_Tack12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LocationSearchEngine {
    public List<Location> filterLocations(List<Location> locationList, Predicate<Location> predicate){
        List<Location> locations = new ArrayList<>();
        for (Location loc : locationList){
            if(predicate.test(loc)){
                locations.add(loc);
            }
        }
        return locations;
    }
    public void processLocations(List<Location> locationList, Consumer<Location> consumer){
        for (Location loc : locationList){
            consumer.accept(loc);
        }
    }
    public List<Double> calculateDistances(List<Location> locationList, Function<Location, Double> function){
        List<Double> routeDistance = new ArrayList<>();
        for (Location loc : locationList){
            routeDistance.add(function.apply(loc));
        }
        return routeDistance;
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
    }
}
