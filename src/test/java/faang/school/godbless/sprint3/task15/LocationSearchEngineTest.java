package faang.school.godbless.sprint3.task15;

import faang.school.godbless.sprint3.lambda.task15.Location;
import faang.school.godbless.sprint3.lambda.task15.LocationSearchEngine;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LocationSearchEngineTest {
    private ByteArrayOutputStream outContent;
    private PrintStream originalOut;
    private List<Location> locations;
    private LocationSearchEngine searchEngine;

    @BeforeEach
    void setUp() {
        locations = new ArrayList<>(Arrays.asList(
                new Location("Eiffel Tower", 48.8584, 2.2945),
                new Location("Statue of Liberty", 40.6892, -74.0445),
                new Location("Great Wall of China", 40.4319, 116.5704)
        ));
        searchEngine = new LocationSearchEngine();
        originalOut = System.out;
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    void testFilterLocations() {
        List<Location> expected = List.of(new Location("Eiffel Tower", 48.8584, 2.2945),
                new Location("Great Wall of China", 40.4319, 116.5704));

        List<Location> actual = searchEngine.filterLocations(locations, (location) -> location.getLongitude() > 0);

        assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    void processLocations() {
        String expected = "Eiffel Tower\r\nStatue of Liberty\r\nGreat Wall of China\r\n";

        searchEngine.processLocations(locations, (location) -> System.out.println(location.getName()));

        assertEquals(expected, outContent.toString());
    }

    @Test
    void calculateDistances() {
        List<Double> expected = List.of(124.90327210653851, 48.150573869892774, 238.67347960814584);
        double baseLatitude = 37.4220;
        double baseLongitude = -122.0841;
        List<Double> actual = searchEngine.calculateDistances(locations, (location) -> {
            double latitudeDiff = Math.abs(location.getLatitude() - baseLatitude);
            double longitudeDiff = Math.abs(location.getLongitude() - baseLongitude);
            return Math.sqrt(Math.pow(latitudeDiff, 2) + Math.pow(longitudeDiff, 2));
        });

        assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    void testValidationFilterLocations() {
        assertThrows(IllegalArgumentException.class, () -> searchEngine.filterLocations(null, null));
        assertThrows(IllegalArgumentException.class, () -> searchEngine.filterLocations(locations, null));
    }

    @Test
    void testValidationProcessLocations() {
        assertThrows(IllegalArgumentException.class, () -> searchEngine.processLocations(null, null));
        assertThrows(IllegalArgumentException.class, () -> searchEngine.processLocations(locations, null));
    }

    @Test
    void testValidationCalculateDistances() {
        assertThrows(IllegalArgumentException.class, () -> searchEngine.calculateDistances(null, null));
        assertThrows(IllegalArgumentException.class, () -> searchEngine.calculateDistances(locations, null));
        locations.add(null);
        assertThrows(IllegalArgumentException.class, () -> searchEngine.calculateDistances(locations, null));
    }
}