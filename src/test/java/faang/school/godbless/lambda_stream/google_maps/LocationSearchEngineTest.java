package faang.school.godbless.lambda_stream.google_maps;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LocationSearchEngineTest {
    List<Location> locations;
    Location eiffel;
    Location liberty;
    Location greatWall;

    @BeforeEach
    void setUp() {
        eiffel = new Location("Eiffel Tower", 48.8584, 2.2945);
        liberty = new Location("Statue of Liberty", 40.6892, -74.0445);
        greatWall = new Location("Great Wall of China", 40.4319, 116.5704);
        locations = new ArrayList<>(Arrays.asList(eiffel, liberty, greatWall));
    }

    @Test
    void testFilterLocations() {
        List<Location> filteredLocations = LocationSearchEngine
                .filterLocations(locations, (location) -> location.getLongitude() > 0);

        assertEquals(2, filteredLocations.size());
        assertFalse(filteredLocations.contains(liberty));
    }

    @Test
    void testProcessLocations() {
        LocationSearchEngine.processLocations(locations, (location) -> System.out.println(location.getName()));
    }

    @Test
    void testCalculateDistances() {
        double baseLatitude = 37.4220;
        double baseLongitude = -122.0841;
        List<Double> distances = LocationSearchEngine.calculateDistances(locations, (location) -> {
            double latitudeDiff = Math.abs(location.getLatitude() - baseLatitude);
            double longitudeDiff = Math.abs(location.getLongitude() - baseLongitude);
            return Math.sqrt(Math.pow(latitudeDiff, 2) + Math.pow(longitudeDiff, 2));
        });
        assertEquals(3, distances.size());
    }
}