import faang.school.godbless.googleMaps.Location;
import faang.school.godbless.googleMaps.LocationSearchEngine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LocationSearchEngineTest {
    LocationSearchEngine searchEngine;
    List<Location> locations;
    List<Location> filteredLocations;
    List<Double> distances;

    @BeforeEach
    public void init() {
        searchEngine = new LocationSearchEngine();

        locations = new ArrayList<>(Arrays.asList(
                new Location("Eiffel Tower", 48.8584, 2.2945),
                new Location("Statue of Liberty", 40.6892, -74.0445),
                new Location("Great Wall of China", 40.4319, 116.5704)));
    }

    @Test
    public void locationSearchEngineTest() {

        // Фильтруем местоположения по долготе
        filteredLocations = searchEngine.filterLocations(locations, (location) -> location.getLongitude() > 0);
        assertEquals(2, filteredLocations.size());
        assertTrue(filteredLocations.contains(locations.get(0)));
        assertFalse(filteredLocations.contains(locations.get(1)));
        assertTrue(filteredLocations.contains(locations.get(2)));
    }

    @Test
    public void calculateDistance() {
        // Вычисляем расстояния от заданной точки до каждого местоположения
        double baseLatitude = 37.4220;
        double baseLongitude = -122.0841;
        distances = searchEngine.calculateDistances(locations, (location) -> {
            double latitudeDiff = Math.abs(location.getLatitude() - baseLatitude);
            double longitudeDiff = Math.abs(location.getLongitude() - baseLongitude);
            return Math.sqrt(Math.pow(latitudeDiff, 2) + Math.pow(longitudeDiff, 2));
        });
        List<Double> expected = List.of(124.90327210653851, 48.150573869892774, 238.67347960814584);
        assertEquals(expected, distances);
    }
}

