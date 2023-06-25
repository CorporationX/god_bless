package faang.school.godbless;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class LocationSearchEngineTest {

    LocationSearchEngine searchEngine;

    @BeforeEach
    public void onSet() {
        searchEngine = new LocationSearchEngine();
    }

    @ParameterizedTest
    @MethodSource("filterLocationsTestData")
    public void filterLocations_shouldReturnFilteredLocations(List<Location> locations,
                                                              Predicate<Location> predicate,
                                                              List<Location> expectedFilteredLocations) {
        List<Location> filteredLocations = searchEngine.filterLocations(locations, predicate);
        assertEquals(expectedFilteredLocations, filteredLocations);
    }

    private static Stream<Object[]> filterLocationsTestData() {
        List<Location> locations = Arrays.asList(
                new Location("Eiffel Tower", 48.8584, 2.2945),
                new Location("Statue of Liberty", 40.6892, -74.0445),
                new Location("Great Wall of China", 40.4319, 116.5704),
                new Location("Sydney Opera House", -33.8568, 151.2153)
        );

        return Stream.of(
                new Object[]{locations, (Predicate<Location>) location -> location.getLongitude() < 0, Arrays.asList(
                        new Location("Statue of Liberty", 40.6892, -74.0445)
                )},
                new Object[]{locations, (Predicate<Location>) location -> location.getName().contains("Tower"), Arrays.asList(
                        new Location("Eiffel Tower", 48.8584, 2.2945)
                )}
        );
    }

    @Test
    public void processLocations_shouldPerformActionForEachLocation() {
        List<Location> locations = Arrays.asList(
                new Location("Eiffel Tower", 48.8584, 2.2945),
                new Location("Statue of Liberty", 40.6892, -74.0445),
                new Location("Great Wall of China", 40.4319, 116.5704)
        );

        List<String> visitedLocations = new ArrayList<>();
        Consumer<Location> action = location -> visitedLocations.add(location.getName());

        searchEngine.processLocations(locations, action);

        List<String> expectedVisitedLocations = Arrays.asList("Eiffel Tower", "Statue of Liberty", "Great Wall of China");
        assertEquals(expectedVisitedLocations, visitedLocations);
    }

    @ParameterizedTest
    @MethodSource("calculateDistancesTestData")
    public void calculateDistances_shouldReturnDistancesFromBaseLocation(List<Location> locations,
                                                                         double baseLatitude, double baseLongitude,
                                                                         List<Double> expectedDistances) {
        Function<Location, Double> distanceFunction = location -> {
            double latitudeDiff = Math.abs(location.getLatitude() - baseLatitude);
            double longitudeDiff = Math.abs(location.getLongitude() - baseLongitude);
            return Math.sqrt(Math.pow(latitudeDiff, 2) + Math.pow(longitudeDiff, 2));
        };

        List<Double> distances = searchEngine.calculateDistances(locations, distanceFunction);
        assertEquals(expectedDistances, distances);
    }

    private static Stream<Object[]> calculateDistancesTestData() {
        List<Location> locations = Arrays.asList(
                new Location("Eiffel Tower", 48.8584, 2.2945),
                new Location("Statue of Liberty", 40.6892, -74.0445),
                new Location("Great Wall of China", 40.4319, 116.5704),
                new Location("Sydney Opera House", -33.8568, 151.2153)
        );

        return Stream.of(
                new Object[]{locations, 37.4220, -122.0841, Arrays.asList(
                        124.90327210653851, 48.150573869892774, 238.67347960814584, 282.44155036007004
                )},
                new Object[]{locations, 40.6892, -74.0445, Arrays.asList(
                        76.77485753578446, 0.0, 190.61507365709565, 237.27427928884327
                )}
        );
    }
}