package faang.school.godbless.sprint_3.google_maps;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        LocationSearchEngine locationSearchEngine = new LocationSearchEngine();

        List<Location> locationList = List.of(new Location("Eiffel Tower", 48.8584, 2.2945),
                new Location("Statue of Liberty", 40.6892, -74.0445),
                new Location("Great Wall of China", 40.4319, 116.5704));
        List<Location> filteredList = locationSearchEngine.filterLocations(locationList, location -> location.getLatitude() < 45.22);
        locationSearchEngine.processLocations(locationList, location -> System.out.println(location.getName()));
        double baseLatitude = 37.4220;
        double baseLongitude = -122.0841;
        List<Double> distances = locationSearchEngine.calculateDistances(locationList, (location) -> {
            double latitudeDiff = Math.abs(location.getLatitude() - baseLatitude);
            double longitudeDiff = Math.abs(location.getLongitude() - baseLongitude);
            return Math.sqrt(Math.pow(latitudeDiff, 2) + Math.pow(longitudeDiff, 2));
        });
        System.out.println(filteredList.toString());
        System.out.println(distances.toString());
    }
}
