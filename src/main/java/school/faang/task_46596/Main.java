package school.faang.task_46596;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
public class Main {
    private static final List<Location> locations = new ArrayList<>(Arrays.asList(
            new Location("Eiffel Tower", 48.8584, 2.2945),
            new Location("Statue of Liberty", 40.6892, -74.0445),
            new Location("Great Wall of China", 40.4319, 116.5704)
    ));

    public static void main(String[] args) {
        LocationSearchEngine searchEngine = new LocationSearchEngine();

        // Фильтруем местоположения по долготе
        List<Location> filteredLocations = searchEngine.filterLocations(locations,
                location -> location.longitude() > 0);

        // Выводим названия отфильтрованных местоположений
        searchEngine.processLocations(filteredLocations, location -> log.info(location.name()));

        // Вычисляем расстояния от заданной точки до каждого местоположения
        double baseLatitude = 37.4220;
        double baseLongitude = -122.0841;
        List<Double> distances = searchEngine.calculateDistances(locations, location -> {
            double latitudeDiff = Math.abs(location.latitude() - baseLatitude);
            double longitudeDiff = Math.abs(location.longitude() - baseLongitude);
            return Math.sqrt(Math.pow(latitudeDiff, 2) + Math.pow(longitudeDiff, 2));
        });
        log.info("{}", distances);
    }

}
