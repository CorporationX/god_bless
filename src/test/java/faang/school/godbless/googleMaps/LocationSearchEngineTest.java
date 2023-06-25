package faang.school.godbless.googleMaps;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;

class LocationSearchEngineTest {
    private LocationSearchEngine locationSearchEngine;
    private List<Location> locations;
    private Predicate<Location> condition;
    private Consumer<Location> action;
    private Function<Location, Double> function;
    private Location eiffelTower;
    private Location statueOfLiberty;
    private Location greatWallOfChina;
    private double baseLatitude;
    private double baseLongitude;

    @BeforeEach
    void setUp() {
        locationSearchEngine = new LocationSearchEngine();
        baseLatitude = 37.4220;
        baseLongitude = -122.0841;

        condition = (location) -> location.getLatitude() > 45;
        action = (location) -> System.out.println(location.getName());
        function = (location) -> {
            double latitudeDiff = Math.abs(location.getLatitude() - baseLatitude);
            double longitudeDiff = Math.abs(location.getLongitude() - baseLongitude);
            return Math.sqrt(Math.pow(latitudeDiff, 2) + Math.pow(longitudeDiff, 2));
        };

        eiffelTower = new Location("Eiffel Tower", 48.8584, 2.2945);
        statueOfLiberty = new Location("Statue of Liberty", 40.6892, -74.0445);
        greatWallOfChina = new Location("Great Wall of China", 40.4319, 116.5704);
        locations = Arrays.asList(eiffelTower, statueOfLiberty, greatWallOfChina);
    }

    @Test
    void testFilterLocations() {
        List<Location> expectedLocations = Arrays.asList(eiffelTower);
        assertEquals(expectedLocations, locationSearchEngine.filterLocations(locations, condition));
    }

    @Test
    void testProcessLocations() {
        locationSearchEngine.processLocations(locations, action);
    }


    @Test
    void testCalculateDistances() {
        List<Double> expectedDistances = getExpectedDistances(locations);
        assertEquals(expectedDistances, locationSearchEngine.calculateDistances(locations, function));
    }

    private List<Double> getExpectedDistances(List<Location> locations) {
        List<Double> distances = new ArrayList<>();
        for (Location location : locations) {
            double latitudeDiff = Math.abs(location.getLatitude() - baseLatitude);
            double longitudeDiff = Math.abs(location.getLongitude() - baseLongitude);
            distances.add(Math.sqrt(Math.pow(latitudeDiff, 2) + Math.pow(longitudeDiff, 2)));
        }
        return distances;
    }
}