package faang.school.godbless.sprint3.googleMaps.classes;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;

class LocationSearchEngineTest {
    private final static Predicate<Location> isLatitudeAndLongitudeLessThan10 =
            location -> location.getLatitude() > 10.0 && location.getLongitude() > 10.0;
    private final static Consumer<Location> getLocationName = location -> System.out.println(location.getName());
    private final static Function<Location, Double> getDistance = (location) -> {
        double baseLatitude = 0.0;
        double baseLongitude = 0.0;
        double latitudeDiff = Math.abs(location.getLatitude() - baseLatitude);
        double longitudeDiff = Math.abs(location.getLongitude() - baseLongitude);
        return Math.sqrt(Math.pow(latitudeDiff, 2) + Math.pow(longitudeDiff, 2));
    };

    private static List<Location> locations = new ArrayList<>(Arrays.asList(
            new Location("Eiffel Tower", 48.8584, 2.2945),
            new Location("Statue of Liberty", 40.6892, -74.0445),
            new Location("Great Wall of China", 40.4319, 116.5704)
    ));


    @Test
    @DisplayName("Predicate test")
    void filterLocation_test() {
        List<Location> list = LocationSearchEngine.filterLocation(locations, isLatitudeAndLongitudeLessThan10);
        assertEquals(1, list.size());
    }

    @Test
    @DisplayName("Function Test")
    void calculateDistance_test() {
        List<Double> list = LocationSearchEngine.calculateDistance(locations, getDistance);
        assertEquals(3, list.size());
        assertAll(
                () -> assertEquals(48.912247758715814, list.get(0)),
                () -> assertEquals(84.4878628969274, list.get(1)),
                () -> assertEquals(123.38312969677014, list.get(2))
        );
    }

    @Test
    @DisplayName("Consumer test")
    void processLocation_test() {
        assertDoesNotThrow(() -> LocationSearchEngine.processLocation(locations, getLocationName));
    }

}