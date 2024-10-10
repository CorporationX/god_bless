package google_maps;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LocationSearchEngineTest {
    private final List<Location> LOCATIONS = new ArrayList<>(Arrays.asList(
            new Location("Eiffel Tower", 48.8584, 2.2945),
            new Location("Statue of Liberty", 40.6892, -74.0445),
            new Location("Great Wall of China", 40.4319, 116.5704)
    ));

    private final LocationSearchEngine SEARCH_ENGINE = new LocationSearchEngine();

    private final List<Location> FILTERED_LOCATIONS = SEARCH_ENGINE.filterLocations(LOCATIONS, (location) -> location.getLongitude() > 0);

    @Test
    void filterLocations() {
        List<Location> filteredLocations = SEARCH_ENGINE.filterLocations(LOCATIONS, (location) -> location.getLongitude() > 0);

        assertEquals(new Location("Eiffel Tower", 48.8584, 2.2945), filteredLocations.get(0));
        assertEquals(new Location("Great Wall of China", 40.4319, 116.5704), filteredLocations.get(1));
    }

    @Test
    void processLocations() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        SEARCH_ENGINE.processLocations(FILTERED_LOCATIONS, (location) -> System.out.println(location.getName()));

        assertEquals(
                "Eiffel Tower\n" +
                "Great Wall of China\n",
                outContent.toString());

        System.setOut(originalOut);
    }

    @Test
    void calculateDistances() {
        double baseLatitude = 37.4220;
        double baseLongitude = -122.0841;

        List<Double> distances = SEARCH_ENGINE.calculateDistances(LOCATIONS, (location) -> {
            double latitudeDiff = Math.abs(location.getLatitude() - baseLatitude);
            double longitudeDiff = Math.abs(location.getLongitude() - baseLongitude);
            return Math.sqrt(Math.pow(latitudeDiff, 2) + Math.pow(longitudeDiff, 2));
        });

        assertEquals(List.of(124.90327210653851, 48.150573869892774, 238.67347960814584), distances);
    }
}