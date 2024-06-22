package faang.school.godbless.task_28_google_maps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LocationSearchEngine {
    public static void main(String[] args) {
        List<Location> locationList = new ArrayList<>(Arrays.asList(
                new Location("Eiffel Tower", 48.8584, 2.2945),
                new Location("Statue of Liberty", 40.6892, -74.0445),
                new Location("Great Wall of China", 40.4319, 116.5704)
        ));

        LocationSearchEngine searchEngine = new LocationSearchEngine();

        List<Location> filteredLocations = searchEngine.filterLocations(locationList, (location) -> location.longitude() > 0);

        searchEngine.processLocations(filteredLocations, (location) -> System.out.println(location.name()));

        double baseLatitude = 37.4220;
        double baseLongitude = -122.0841;
        List<Double> distances = searchEngine.calculateDistances(locationList, (location) -> {
            double latitudeDiff = Math.abs(location.latitude() - baseLatitude);
            double longitudeDiff = Math.abs(location.longitude() - baseLongitude);
            return Math.sqrt(Math.pow(latitudeDiff, 2) + Math.pow(longitudeDiff, 2));
        });

        distances.forEach(System.out::println);
    }

    public List<Location> filterLocations(List<Location> locationList, Predicate<Location> predicate) {
        List<Location> filteredList = new ArrayList<>();
        for (Location location : locationList) {
            if (predicate.test(location)) {
                filteredList.add(location);
            }
        }
        return filteredList;
    }

    public void processLocations(List<Location> locationList, Consumer<Location> consumer) {
        for (Location location : locationList) {
            consumer.accept(location);
        }
    }

    public List<Double> calculateDistances(List<Location> locationList, Function<Location, Double> function) {
        List<Double> distancesList = new ArrayList<>();

        for (Location location : locationList) {
            distancesList.add(function.apply(location));
        }
        return distancesList;
    }
}
