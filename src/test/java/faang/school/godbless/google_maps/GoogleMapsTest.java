package faang.school.godbless.google_maps;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GoogleMapsTest {

    private List<Location> locations;
    private LocationSearchEngine searchEngine;

    @BeforeEach
    public void setUp() {
        locations = new ArrayList<>(Arrays.asList(
                new Location("Eiffel Tower", 48.8584, 2.2945),
                new Location("Statue of Liberty", 40.6892, -74.0445),
                new Location("Great Wall of China", 40.4319, 116.5704)
        ));
        searchEngine = new LocationSearchEngine();
    }

    @Test
    public void testLongitudeFilter() {
        List<Location> filteredLocations = searchEngine.filterLocations(locations, (location) -> location.getLongitude() > 0);
        Assertions.assertEquals(2, filteredLocations.size());
    }

    @Test
    public void testProcessLocations() {
        searchEngine.processLocations(locations, (location) -> location.setLatitude(0.0));
        Assertions.assertEquals(0.0, locations.get(0).getLatitude());
    }

    @Test
    public void testCalculateDistances() {
        double baseLatitude = 37.4220;
        double baseLongitude = -122.0841;
        List<Double> distances = searchEngine.calculateDistances(locations, (location) -> {
            double latitudeDiff = Math.abs(location.getLatitude() - baseLatitude);
            double longitudeDiff = Math.abs(location.getLongitude() - baseLongitude);
            return Math.sqrt(Math.pow(latitudeDiff, 2) + Math.pow(longitudeDiff, 2));
        });
        Assertions.assertEquals(125, Math.round(distances.get(0)));
        System.out.println(distances);
    }
}
