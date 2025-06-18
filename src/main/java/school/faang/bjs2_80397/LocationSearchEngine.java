package school.faang.bjs2_80397;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LocationSearchEngine {

    public List<Location> filterLocations(List<Location> locations, Predicate<Location> predicate) {
        if (locations == null || predicate == null) {
            throw new IllegalArgumentException("Locations or predicate must not be null");
        }
        return locations.stream()
                .filter(predicate)
                .collect(Collectors.toList());
    }

    public void processLocations(List<Location> locations, Consumer<Location> consumer) {
        if (locations == null || consumer == null) {
            throw new IllegalArgumentException("Locations or consumer must not be null");
        }
        locations.forEach(consumer);
    }

    public List<Double> calculateDistances(List<Location> locations, Function<Location, Double> distanceFunction) {
        if (locations == null || distanceFunction == null) {
            throw new IllegalArgumentException("Locations or distance function must not be null");
        }
        return locations.stream()
                .map(distanceFunction)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Location> locations = Arrays.asList(
                new Location("Eiffel Tower", 48.8584, 2.2945),
                new Location("Statue of Liberty", 40.6892, -74.0445),
                new Location("Great Wall of China", 40.4319, 116.5704)
        );

        final double greenwichLongitude = 0.0;
        final double baseLatitude = 37.4220;
        final double BaseLongitude = -122.0841;

        LocationSearchEngine searchEngine = new LocationSearchEngine();

        List<Location> filteredLocations = searchEngine.filterLocations(
                locations, location -> location.getLongitude() > greenwichLongitude
        );

        searchEngine.processLocations(filteredLocations,
                location -> System.out.println(location.getName())
        );

        Function<Location, Double> calculator = new DistanceCalculator(baseLatitude, BaseLongitude);

        List<Double> distances = searchEngine.calculateDistances(locations, calculator);

        for (int i = 0; i < locations.size(); i++) {
            System.out.printf("Distance to %s: %.4f%n", locations.get(i).getName(), distances.get(i));
        }
    }
}
