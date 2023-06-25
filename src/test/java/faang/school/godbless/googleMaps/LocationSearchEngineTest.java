package faang.school.godbless.googleMaps;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
public class LocationSearchEngineTest {
    @Test
    public void testFilterLocations() {
        List<Location> locations = new ArrayList<>(Arrays.asList(
                new Location("Eiffel Tower", 48.8584, 2.2945),
                new Location("Statue of Liberty", 40.6892, -74.0445),
                new Location("Great Wall of China", 40.4319, 116.5704)
        ));

        LocationSearchEngine searchEngine = new LocationSearchEngine();

        List<Location> filteredLocations = searchEngine.filterLocations(locations, (location) -> location.getLongitude() > 0);

        assertEquals(2, filteredLocations.size());
    }

    @Test
    public void testCalculateDistances() {
        List<Location> locations = new ArrayList<>(Arrays.asList(
                new Location("Eiffel Tower", 48.8584, 2.2945),
                new Location("Statue of Liberty", 40.6892, -74.0445),
                new Location("Great Wall of China", 40.4319, 116.5704)
        ));

        LocationSearchEngine searchEngine = new LocationSearchEngine();

        double initLatitude = 37.4220;
        double initLongitude = -122.0841;
        List<Double> distances = searchEngine.calculateDistances(locations, (location) -> {
            double latitudeDiff = Math.abs(location.getLatitude() - initLatitude);
            double longitudeDiff = Math.abs(location.getLongitude() - initLongitude);
            return Math.sqrt(Math.pow(latitudeDiff, 2) + Math.pow(longitudeDiff, 2));
        });

        assertEquals(3, distances.size());
    }
  
}