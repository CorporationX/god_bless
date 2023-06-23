package faang.school.godbless.google_maps;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LocationSearchEngineTest {

    List<Location> locations;
    private LocationSearchEngine searchEngine;

    @BeforeEach
    void setUp() {
        searchEngine = new LocationSearchEngine();

        locations = List.of(new Location("Statue of Liberty", 40.6892, -74.0445));

    }

    @Test
    void testFilterLocations() {
        List<Location> filterLocations = searchEngine.filterLocations(locations, (location) -> location.getLongitude() > 0);
        int actualOutput = filterLocations.size();
        int expectedOutput = 0;

        assertEquals(expectedOutput,actualOutput);
    }

    @Test
    void testCalculateDistance(){
        double baseLatitude = 37.4220;
        double baseLongitude = -122.0841;

        List<Double> distances = searchEngine.calculateDistances(locations, (location) -> {
            double latitudeDiff = Math.abs(location.getLatitude() - baseLatitude);
            double longitudeDiff = Math.abs(location.getLongitude() - baseLongitude);
            return Math.sqrt(Math.pow(latitudeDiff, 2) + Math.pow(longitudeDiff, 2));
        });

        double actualOutput = distances.get(0);
        double expectedOutput = 48.150573869892774;

        assertEquals(expectedOutput,actualOutput);
    }
}
