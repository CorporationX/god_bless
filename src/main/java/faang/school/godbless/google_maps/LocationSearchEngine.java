package faang.school.godbless.google_maps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LocationSearchEngine {
    public static List<Location> filterLocation(List<Location> locations, Predicate<Location> locationFilter) {
        return locations.stream().filter(location -> locationFilter.test(location)).collect(Collectors.toList());
    }
    public void processLocation(List<Location> locations, Consumer<Location> handler) {
        locations.stream().forEach(location -> handler.accept(location));
    }
    public List<Double> calculateDistances(List<Location> locations, Function<Location, Double> calculator) {
        return locations.stream().map(location -> calculator.apply(location)).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Location> locations = new ArrayList<>(Arrays.asList(
                new Location("Eiffel Tower", 48.8584, 2.2945),
                new Location("Statue of Liberty", 40.6892, -74.0445),
                new Location("Great Wall of China", 40.4319, 116.5704)
        ));

        LocationSearchEngine searchEngine = new LocationSearchEngine();


        List<Location> filteredLocations = searchEngine.filterLocation(locations, (location) -> location.getLongitude() > 0);


        searchEngine.processLocation(filteredLocations, (location) -> System.out.println(location.getName()));


        double baseLatitude = 37.4220;
        double baseLongitude = -122.0841;
        List<Double> distances = searchEngine.calculateDistances(locations, (location) -> {
            double latitudeDiff = Math.abs(location.getLatitude() - baseLatitude);
            double longitudeDiff = Math.abs(location.getLongitude() - baseLongitude);
            return Math.sqrt(Math.pow(latitudeDiff, 2) + Math.pow(longitudeDiff, 2));
        });
        System.out.println(distances);
    }
}
