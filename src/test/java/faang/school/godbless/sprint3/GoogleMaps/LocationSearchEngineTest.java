package faang.school.godbless.sprint3.GoogleMaps;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LocationSearchEngineTest {
    private ByteArrayOutputStream output = new ByteArrayOutputStream();

    List<Location> locations = new ArrayList<>(Arrays.asList(
            new Location("Eiffel Tower", 48.8584, 2.2945),
            new Location("Statue of Liberty", 40.6892, -74.0445)
    ));

    LocationSearchEngine searchEngine = new LocationSearchEngine();
    @Test
    void filterLocations() {
        List<Location> filteredLocations = searchEngine.filterLocations(locations, (location) -> location.getLongitude() > 0);
        assertTrue(!filteredLocations.isEmpty());
        assertEquals(1,filteredLocations.size());

        System.setOut(new PrintStream(output));
        searchEngine.processLocations(filteredLocations, (location) -> System.out.println(location.getName()));
        assertEquals("Eiffel Tower\n", output.toString());
        System.setOut(null);

        double baseLatitude = filteredLocations.get(0).getLatitude();
        double baseLongitude = filteredLocations.get(0).getLongitude();
        List<Double> distances = searchEngine.calculateDistances(locations, (location) -> {
            double latitudeDiff = Math.abs(location.getLatitude() - baseLatitude);
            double longitudeDiff = Math.abs(location.getLongitude() - baseLongitude);
            return Math.sqrt(Math.pow(latitudeDiff, 2) + Math.pow(longitudeDiff, 2));
        });
        assertEquals(0, distances.get(0));
    }
}