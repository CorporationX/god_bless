package faang.school.godbless.secondSprint.GoogleMaps;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LocationSearchEngineTest {
    LocationSearchEngine locationSearchEngine;
    List<Location> locations;

    @BeforeEach
    public void setUp() {
        locationSearchEngine = new LocationSearchEngine();
        locations = List.of(
                new Location("Кремль", 2.0, 4.0),
                new Location("Дворцовая площадь", 5.0, 10.0),
                new Location("Дом", 9.0, 4.0)
        );
    }

    @Test
    public void testFilterLocations() {
        List<Location> result = locationSearchEngine.filterLocations(locations,
                (location -> location.getLatitude() > 5));
        Location expected = new Location("Дом", 9.0, 4.0);

        assertEquals(1, result.size());
        assertEquals(expected, result.get(0));
    }

    @Test
    public void testProcessLocations() {
        locationSearchEngine.processLocations(locations, location -> location.setName(location.getName() + " Россия"));
        String expected = "Кремль Россия";

        assertEquals(3, locations.size());
        assertEquals(expected, locations.get(0).getName());
    }

    @Test
    public void testCalculateDistances() {
        double baseLatitude = 0;
        double baseLongitude = 0;

        List<Double> result = locationSearchEngine.calculateDistances(locations, (location) -> {
            double latitudeDiff = Math.abs(location.getLatitude() - baseLatitude);
            double longitudeDiff = Math.abs(location.getLongitude() - baseLongitude);
            return Math.sqrt(Math.pow(latitudeDiff, 2) + Math.pow(longitudeDiff, 2));
        });
        List<Double> expected = List.of(
                Math.sqrt(20),
                Math.sqrt(125),
                Math.sqrt(97)
        );

        assertEquals(expected, result);
    }

}