package faang.school.godbless;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LocationSearchEngineTest {
    List<Location> locations;
    LocationSearchEngine searchEngine;

    @BeforeEach
    void setUp() {
        locations = new ArrayList<>(Arrays.asList(
                new Location("Eiffel Tower", 48.8584, 2.2945),
                new Location("Statue of Liberty", 40.6892, -74.0445),
                new Location("Great Wall of China", 40.4319, 116.5704)
        ));
        searchEngine = new LocationSearchEngine();
    }

    @Test
    void testFilterLocations() {
        List<Location> filteredLocations = searchEngine.filterLocations(locations, (location) -> location.getLongitude() > 0);
        assertEquals(filteredLocations.size(), 2);
    }

    @Test
    void testProcessLocations() {
        searchEngine.processLocations(locations, (item) -> item.setLongitude(item.getLongitude() + 10));
        assertEquals(locations.get(0).getLongitude(), 12.2945);
    }

    @Test
    void testCalculateDistances() {
        double baseLatitude = 37.4220;
        double baseLongitude = -122.0841;
        List<Double> distances = searchEngine.calculateDistances(locations, (location) -> {
            double latitudeDiff = Math.abs(location.getLatitude() - baseLatitude);
            double longitudeDiff = Math.abs(location.getLongitude() - baseLongitude);
            return Math.sqrt(Math.pow(latitudeDiff, 2) + Math.pow(longitudeDiff, 2));
        });
        System.out.println(distances);
        System.out.println("Оно работает)))");
    }
}