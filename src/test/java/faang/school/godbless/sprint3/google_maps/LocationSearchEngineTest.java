package faang.school.godbless.sprint3.google_maps;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LocationSearchEngineTest {
    private List<Location> locations;
    private LocationSearchEngine searchEngine;

    @BeforeEach
    void setLocationsAndEngine() {
         locations = new ArrayList<>(Arrays.asList(
                new Location("Eiffel Tower", 48.8584, 2.2945),
                new Location("Statue of Liberty", 40.6892, -74.0445),
                new Location("Great Wall of China", 40.4319, 116.5704)
        ));
         searchEngine = new LocationSearchEngine();
    }

    @Test
    void filterLocations_shouldReturnFilteredList() {
        List<Location> filteredLocations = searchEngine.filterLocations(
                locations,
                (location) -> location.getLongitude() > 0
        );

        assertAll(() -> {
            assertTrue(locations.size() > filteredLocations.size());
            assertEquals(filteredLocations.size(), 2);
        });
    }

    @Test
    void processLocations_shouldPrintLocationNames() {
        PrintStream console = System.out;
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        searchEngine.processLocations(locations, (location) -> System.out.println(location.getName()));

        System.setOut(console);

        List<String> expectedLocationNames = List.of(output.toString().split("\n"));

        for (int i = 0; i < locations.size(); i++) {
            assertEquals(expectedLocationNames.get(0), locations.get(0).getName());
        }
    }

    @Test
    void calculateDistances_shouldReturnDistanceListInDoubleFormat() {
        double baseLatitude = 37.4220;
        double baseLongitude = -122.0841;
        List<Double> distances = searchEngine.calculateDistances(locations, (location) -> {
            double latitudeDiff = Math.abs(location.getLatitude() - baseLatitude);
            double longitudeDiff = Math.abs(location.getLongitude() - baseLongitude);
            return Math.sqrt(Math.pow(latitudeDiff, 2) + Math.pow(longitudeDiff, 2));
        });

        // что-то я не придумал как нормально этот метод протестировать))
        assertEquals("Double", distances.get(0).getClass().getSimpleName());
        assertEquals(3, distances.size());
    }
}