package school.faang.google.maps;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LocationSearchEngineTest {
    private static final double BASE_LATITUDE = 37.4220;
    private static final double BASE_LONGITUDE = 37.4220;
    private List<Location> locations;
    private List<Location> savedLocations;

    private Predicate<Location> filterLocations;
    private Consumer<Location> saveLocations;
    private Function<Location, Double> calculateDistances;


    @BeforeEach
    public void setUp() {
        locations = Arrays.asList(
                new Location("Eiffel Tower", 48.8584, 2.2945),
                new Location("Statue of Liberty", 40.6892, -74.0445),
                new Location("Great Wall of China", 40.4319, 116.5704)
        );
        savedLocations = new ArrayList<>();

        filterLocations = location -> location.getLongitude() > 0;
        saveLocations = location -> savedLocations.add(location);
        calculateDistances = location -> {
            double latitudeDiff = Math.abs(location.getLatitude() - BASE_LATITUDE);
            double longitudeDiff = Math.abs(location.getLongitude() - BASE_LONGITUDE);
            return Math.sqrt(Math.pow(latitudeDiff, 2) + Math.pow(longitudeDiff, 2));
        };
    }

    @Test
    public void filterLocationsTest() {
        List<Location> expected = Arrays.asList(
                new Location("Eiffel Tower", 48.8584, 2.2945),
                new Location("Great Wall of China", 40.4319, 116.5704)
        );
        List<Location> filteredLocations = LocationSearchEngine.filterLocations(locations, filterLocations);
        assertEquals(expected, filteredLocations);
    }

    @Test
    public void processLocationsTest() {
        LocationSearchEngine.processLocations(locations, saveLocations);
        assertEquals(locations, savedLocations);
    }

    @Test
    public void calculateDistancesTest() {
        List<Double> expected = Arrays.asList(36.94228608532504, 111.51437224900654, 79.2056104109425);
        List<Double> distances = LocationSearchEngine.calculateDistances(locations, calculateDistances);
        assertEquals(expected, distances);
    }
}
