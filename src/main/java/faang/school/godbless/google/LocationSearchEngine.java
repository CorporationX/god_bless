package faang.school.godbless.google;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LocationSearchEngine {
  public List<Location> filterLocations(List<Location> locations, Predicate<Location> predicate) {
    return locations.stream().filter(predicate).toList();
  }

  public void processLocations(List<Location> locations, Consumer<Location> action) {
    locations.forEach(action);
  }

  public List<Double> calculateDistances(List<Location> locations, Function<Location, Double> action) {
    return locations.stream().map(action).toList();
  }
}
