package faang.school.godbless.googleMaps;

import faang.school.godbless.sprint2.googleMaps.Location;
import faang.school.godbless.sprint2.googleMaps.LocationSearchEngine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LocationSearchEngineTest {
    List<Location> locations;
    LocationSearchEngine searchEngine;


    @BeforeEach
    public void init() {
        locations = new ArrayList<>(List.of(
                new Location("Eiffel Tower", 48.8584, 2.2945),
                new Location("Statue of Liberty", 40.6892, -74.0445),
                new Location("Great Wall of China", 40.4319, 116.5704)
        ));

        searchEngine = new LocationSearchEngine();
    }

    @Test
    public void testFilterLocations() {
        List<Location> filteredLocations = searchEngine.filterLocations(locations,
                location -> location.getLongitude() > 0);

        assertEquals(2, filteredLocations.size());
        assertTrue(filteredLocations.contains(locations.get(0)));
        assertFalse(filteredLocations.contains(locations.get(1)));
        assertTrue(filteredLocations.contains(locations.get(2)));
    }

    @Test
    public void testProcessLocation() {
        List<String> printedNames = new ArrayList<>();

        Consumer<Location> nameConsumer = location -> printedNames.add(location.getName());

        searchEngine.processLocations(locations, nameConsumer);

        assertEquals(3, printedNames.size());
        assertTrue(printedNames.contains("Eiffel Tower"));
        assertTrue(printedNames.contains("Statue of Liberty"));
        assertTrue(printedNames.contains("Great Wall of China"));

    }

    @Test
    public void calculateDistancesTest() {
        double baseLatitude = 37.4220;
        double baseLongitude = -122.0841;
        List<Double> result = searchEngine.calculateDistances(locations, (location) -> {
            double latitudeDiff = Math.abs(location.getLatitude() - baseLatitude);
            double longitudeDiff = Math.abs(location.getLongitude() - baseLongitude);
            return Math.sqrt(Math.pow(latitudeDiff, 2) + Math.pow(longitudeDiff, 2));
        });
        List<Double> expected = List.of(124.90327210653851, 48.150573869892774, 238.67347960814584);

        assertEquals(expected, result);
    }
}
