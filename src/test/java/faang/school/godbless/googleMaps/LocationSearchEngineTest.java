package faang.school.godbless.googleMaps;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LocationSearchEngineTest {
    private LocationSearchEngine searchEngine;
    private List<Location> locations;

    @BeforeEach
    void setUp() {
        searchEngine = new LocationSearchEngine();
        locations = new ArrayList<>(Arrays.asList(
                new Location("Eiffel Tower", 48.8584, 2.2945),
                new Location("Statue of Liberty", 40.6892, -74.0445),
                new Location("Great Wall of China", 40.4319, 116.5704)
        ));
    }

    @Test
    public void testFilterLongitude() {
        // Фильтруем местоположения по долготе
        List<Location> filteredLocations = searchEngine.filterLocations(locations, (location) -> location.getLongitude() > 0);

        List<Location> expected = new ArrayList<>(Arrays.asList(
                new Location("Eiffel Tower", 48.8584, 2.2945),
                new Location("Great Wall of China", 40.4319, 116.5704)
        ));

        assertEquals(expected, filteredLocations);
    }

    @Test
    public void testFilterLatitude() {
        // Фильтруем местоположения по долготе
        List<Location> filteredLocations = searchEngine.filterLocations(locations, (location) -> location.getLatitude() > 44);

        List<Location> expected = Collections.singletonList(new Location("Eiffel Tower", 48.8584, 2.2945));

        assertEquals(expected, filteredLocations);
    }

    @Test
    public void testProcessLocations() {
        // Выводим названия отфильтрованных местоположений
        searchEngine.processLocations(locations, (location) -> location.setLatitude(0));

        List<Location> expected = new ArrayList<>(Arrays.asList(
                new Location("Eiffel Tower", 0, 2.2945),
                new Location("Statue of Liberty", 0, -74.0445),
                new Location("Great Wall of China", 0, 116.5704)
        ));

        assertEquals(expected, locations);
    }

    @Test
    public void testCalculate() {
        // Вычисляем расстояния от заданной точки до каждого местоположения
        double baseLatitude = 37.4220;
        double baseLongitude = -122.0841;
        List<Double> distances = searchEngine.calculateDistances(locations, (location) -> {
            double latitudeDiff = Math.abs(location.getLatitude() - baseLatitude);
            double longitudeDiff = Math.abs(location.getLongitude() - baseLongitude);
            return Math.sqrt(Math.pow(latitudeDiff, 2) + Math.pow(longitudeDiff, 2));
        });

        assertEquals(124.9032, distances.get(0), 0.0001);
    }
}