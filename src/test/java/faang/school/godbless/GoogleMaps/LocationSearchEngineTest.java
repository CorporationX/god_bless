package faang.school.godbless.GoogleMaps;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LocationSearchEngineTest {

    LocationSearchEngine searchEngine = new LocationSearchEngine();
    List<Location> locations;
    List<Location> filteredLocations;

    @BeforeEach
    void setUp(){
        locations = new ArrayList<>(Arrays.asList(
                new Location("Eiffel Tower", 48.8584, 2.2945),
                new Location("Statue of Liberty", 40.6892, -74.0445),
                new Location("Great Wall of China", 40.4319, 116.5704)
        ));
        filteredLocations = searchEngine.filterLocations(locations, (location) -> location.longitude() > 0);
    }
    @Test
    void testFiltrationLocations(){
        Assertions.assertFalse(filteredLocations.contains(locations.get(1)));
    }

    @Test
    void testCalculatingDistances() {
        double baseLatitude = 37.4220;
        double baseLongitude = -122.0841;
        List<Double> distances = searchEngine.calculateDistances(locations, (location) -> {
            double latitudeDiff = Math.abs(location.latitude() - baseLatitude);
            double longitudeDiff = Math.abs(location.longitude() - baseLongitude);
            return Math.sqrt(Math.pow(latitudeDiff, 2) + Math.pow(longitudeDiff, 2));
        });
        Assertions.assertEquals(124.90327210653851,distances.get(0));
    }
}