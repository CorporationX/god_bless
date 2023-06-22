package faang.school.godbless.ggogle.maps;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class LocationSearchEngineTest {
    LocationSearchEngine locationSearchEngine;
    List<Location> locations;

    @BeforeEach
    void setUp() {
        locationSearchEngine = new LocationSearchEngine();
        locations = new ArrayList<>(Arrays.asList(
                new Location("Eiffel Tower", 48.8584, 2.2945),
                new Location("Statue of Liberty", 40.6892, -74.0445),
                new Location("Great Wall of China", 40.4319, 116.5704)
        ));
    }

    @Test
    public void filterLocations_CorrectAnswer() {


        List<Location> filteredLocations = locationSearchEngine.filterLocations(locations, (location) -> location.getLongitude() < 0);
        String name = "Statue of Liberty";

        for (int i = 0; i < filteredLocations.size(); i++) {
            assertEquals(name, filteredLocations.get(i).getName());
        }

    }
    @Test
    public void processLocations_CorrectAnswer() {
        locationSearchEngine.processLocations(locations, location -> System.out.println(location.getName()));
    }
    @Test
    public void calculateDistances_CorrectAnswer() {
        double baseLatitude = 37.;
        List<Double> distance = locationSearchEngine.calculateDistances(locations, location -> {
            double distanceLatitude = Math.abs(location.getLatitude()-baseLatitude);
            return distanceLatitude;
        });
        double distanceEiffel = locations.get(0).getLatitude() - baseLatitude;
        double distanceLiberty = locations.get(1).getLatitude() - baseLatitude;
        double distanceWall = locations.get(2).getLatitude() - baseLatitude;

        assertEquals(distanceEiffel, distance.get(0));
        assertEquals(distanceLiberty, distance.get(1));
        assertEquals(distanceWall, distance.get(2));
    }

}