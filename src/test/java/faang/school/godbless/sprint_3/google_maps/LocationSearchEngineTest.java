package faang.school.godbless.sprint_3.google_maps;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;

class LocationSearchEngineTest {
    LocationSearchEngine locationEngine;
    Location firstLocation;
    Location secondLocation;
    Location thirdLocation;
    List<Location> locationList;
    Predicate<Location> predicate;
    Consumer<Location> consumer;
    double baseLatitude;
    double baseLongitude;
    Function<Location, Double> function;

    @BeforeEach
    public void init() {
        locationEngine = new LocationSearchEngine();
        firstLocation = new Location("Eiffel Tower", 48.8584, 2.2945);
        secondLocation = new Location("Statue of Liberty", 40.6892, -74.0445);
        thirdLocation = new Location("Great Wall of China", 40.4319, 116.5704);
        locationList = List.of(firstLocation, secondLocation, thirdLocation);
        predicate = location -> location.getLatitude() < 45.22;
        consumer = location -> System.out.println(location.getName());
        baseLatitude = 37.4220;
        baseLongitude = -122.0841;
        function = (location) -> {
            double latitudeDiff = Math.abs(location.getLatitude() - baseLatitude);
            double longitudeDiff = Math.abs(location.getLongitude() - baseLongitude);
            return Math.sqrt(Math.pow(latitudeDiff, 2) + Math.pow(longitudeDiff, 2));
        };
    }

    @Test
    public void filterLocationsTest() {
        List<Location> expected = List.of(secondLocation, thirdLocation);
        List<Location> result = locationEngine.filterLocations(locationList, predicate);

        assertEquals(expected, result);
        assertFalse(result.contains(firstLocation));

        assertThrows(IllegalArgumentException.class, () -> locationEngine.filterLocations(new ArrayList<>(), predicate));
    }

    @Test
    public void processLocationsTest() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        locationEngine.processLocations(locationList, consumer);

        String firstExpected = "Eiffel Tower";
        String secondExpected = "Statue of Liberty";
        String result = outputStream.toString().trim();

        assertFalse(result.isEmpty());
        assertTrue(result.contains(firstExpected));
        assertTrue(result.contains(secondExpected));

        assertThrows(IllegalArgumentException.class, () -> locationEngine.processLocations(new ArrayList<>(), consumer));
    }

    @Test
    public void calculateDistancesTest() {
        List<Double> expected = List.of(124.90327210653851, 48.150573869892774, 238.67347960814584);
        List<Double> result = locationEngine.calculateDistances(locationList, function);

        assertFalse(result.isEmpty());
        assertEquals(expected, result);

        assertThrows(IllegalArgumentException.class, () -> locationEngine.calculateDistances(new ArrayList<>(), function));
    }
}