package faang.school.godbless.bjs2_22157;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LocationSearchEngineTest {
    LocationSearchEngine locationSearchEngine;
    List<Location> locations;

    @BeforeEach
    void setup() {
        locationSearchEngine = new LocationSearchEngine();
        locations = new ArrayList<>(Arrays.asList(
                new Location("Eiffel Tower", 48.8584, 2.2945),
                new Location("Statue of Liberty", 40.6892, -74.0445),
                new Location("Great Wall of China", 40.4319, 116.5704)
        ));
    }

    @Test
    void filterLocations() {
        var filteredLocations = locationSearchEngine.filterLocations(locations, (location) -> location.getLongitude() > 0);
        assertEquals(2, filteredLocations.size());
    }

    @Test
    void processLocations() {
        locationSearchEngine.processLocations(locations, (location) -> System.out.println(location.getName()));
    }

    @Test
    void calculateDistances() {
        double baseLatitude = 37.4220;
        double baseLongitude = -122.0841;
        List<Double> distances = locationSearchEngine.calculateDistances(locations, (location) -> {
            double latitudeDiff = Math.abs(location.getLatitude() - baseLatitude);
            double longitudeDiff = Math.abs(location.getLongitude() - baseLongitude);
            return Math.sqrt(Math.pow(latitudeDiff, 2) + Math.pow(longitudeDiff, 2));
        });
        assertEquals(3, distances.size());
        assertTrue(Math.abs(124.9032 - distances.get(0)) < 0.0001);
        assertTrue(Math.abs(48.1505 - distances.get(1)) < 0.0001);
        assertTrue(Math.abs(238.6734 - distances.get(2)) < 0.0001);
    }
}