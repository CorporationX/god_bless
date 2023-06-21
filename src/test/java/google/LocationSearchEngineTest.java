package google;

import faang.school.godbless.google.Location;
import faang.school.godbless.google.LocationSearchEngine;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LocationSearchEngineTest {
  List<Location> locations = new ArrayList<>(Arrays.asList(
      new Location("Eiffel Tower", 48.8584, 2.2945),
      new Location("Statue of Liberty", 40.6892, -74.0445),
      new Location("Great Wall of China", 40.4319, 116.5704)
  ));

  LocationSearchEngine searchEngine = new LocationSearchEngine();

  private static final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

  @BeforeAll
  public static void setUp() {
    System.setOut(new PrintStream(outputStreamCaptor));
  }

  @Test
  public void filterLocationsTest() {
    List<Location> filteredLocations = searchEngine.filterLocations(locations, (location) -> location.getLongitude() > 0);
    assertEquals(2, filteredLocations.size());
  }

  @Test
  public void processLocationsTest() {
    searchEngine.processLocations(locations, (location) -> System.out.println(location.getName()));
    assertEquals("Eiffel Tower\n" +
        "Statue of Liberty\n" +
        "Great Wall of China", outputStreamCaptor.toString()
        .trim());
  }

  @Test
  public void calculateDistancesTest() {
    double baseLatitude = 37.4220;
    double baseLongitude = -122.0841;
    List<Double> distances = searchEngine.calculateDistances(locations, (location) -> {
      double latitudeDiff = Math.abs(location.getLatitude() - baseLatitude);
      double longitudeDiff = Math.abs(location.getLongitude() - baseLongitude);
      return Math.sqrt(Math.pow(latitudeDiff, 2) + Math.pow(longitudeDiff, 2));
    });

    assertEquals(List.of(124.90327210653851, 48.150573869892774, 238.67347960814584), distances);
  }
}
