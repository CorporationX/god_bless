package faang.school.godbless.googlemaps;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class LocationSearchEngineTest {
    @Test
    public void filterLocations_shouldReturnFilteredList() {
        LocationSearchEngine searchEngine = new LocationSearchEngine();
        var locations = new ArrayList<>(Arrays.asList(
                new Location("Eiffel Tower", 48.8584, 2.2945),
                new Location("Statue of Liberty", 40.6892, -74.0445),
                new Location("Great Wall of China", 40.4319, 116.5704)
                ));
        var statueOfLiberty = new Location("statue of liberty", -10.3232, 43.7894);
        locations.add(statueOfLiberty);

        var result = searchEngine.filterLocations(locations, (location) -> location.getLatitude() > 0);

        assertEquals(3, result.size());
        assertFalse(result.contains(statueOfLiberty));
    }
}
