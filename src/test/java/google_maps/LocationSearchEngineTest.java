package google_maps;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class LocationSearchEngineTest {
    private List<Location> locations;
    private LocationSearchEngine searchEngine;


    @BeforeEach
    public void setUp() {
        locations = new ArrayList<>(List.of(
                new Location("Eiffel Tower", 48.8584, 2.2945),
                new Location("Statue of Liberty", 40.6892, -74.0445),
                new Location("Great Wall of China", 40.4319, 116.5704)
        ));

        searchEngine = new LocationSearchEngine();
    }

    @Test
    public void testFilterLocations() {
        List<Location> filteredLocations = searchEngine.filterLocations(locations,
                location -> location.longitude() > 0);

        Assertions.assertEquals(2, filteredLocations.size());
        Assertions.assertTrue(filteredLocations.contains(locations.get(0)));
        Assertions.assertFalse(filteredLocations.contains(locations.get(1)));
        Assertions.assertTrue(filteredLocations.contains(locations.get(2)));
    }

    @Test
    public void testProcessLocation() {
        List<String> printedNames = new ArrayList<>();

        Consumer<Location> nameConsumer = location -> printedNames.add(location.name());

        searchEngine.processLocations(locations, nameConsumer);

        Assertions.assertEquals(3, printedNames.size());
        Assertions.assertTrue(printedNames.contains("Eiffel Tower"));
        Assertions.assertTrue(printedNames.contains("Statue of Liberty"));
        Assertions.assertTrue(printedNames.contains("Great Wall of China"));
    }

}