package faang.school.godbless.Sprint_3.Lambda.GoogleMaps;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;

class LocationSearchEngineTest {
    List<Location> locations = new ArrayList<>(Arrays.asList(
            new Location("Eiffel Tower", 48.8584, 2.2945),
            new Location("Statue of Liberty", 40.6892, -74.0445),
            new Location("Kremlin", 55.7520, 37.6175),
            new Location("Great Wall of China", 40.4319, 116.5704)
    ));

    LocationSearchEngine searchEngine = new LocationSearchEngine();

    @Test
    public void filterLocationsTest() {
        Predicate<Location> filter = (location) -> location.getLongitude() >= 0;
        List<Location> result = searchEngine.filterLocations(locations, filter);

        assertEquals(result.size(), 3);
    }

    @Test
    public void calculateDistancesTest() {
        double baseLatitude = 55.7558;
        double baseLongitude = 37.6173;
        Function<Location, Double> function = (location) -> {
            double latitudeDiff = Math.abs(location.getLatitude() - baseLatitude);
            double longitudeDiff = Math.abs(location.getLongitude() - baseLongitude);
            return Math.sqrt(Math.pow(latitudeDiff, 2) + Math.pow(longitudeDiff, 2));
        };
        List<Double> result = searchEngine.calculateDistances(locations, function);

        assertTrue(result.get(2) < 1);
    }

}