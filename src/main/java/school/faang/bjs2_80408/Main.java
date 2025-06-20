package school.faang.bjs2_80408;

import school.faang.Location;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Location sanPaula = new Location("San-Paula", 254.2, 11.4);
        Location kamishin = new Location("Kamishin", 100.10, 204.1);
        Location moskva = new Location("Moskva", 0.0, 0.1);

        List<Location> locationList = new ArrayList<>(List.of(sanPaula, kamishin, moskva));

        LocationSearchEngine locationSearchEngine = new LocationSearchEngine();
        locationSearchEngine.processLocations(locationList, location -> System.out.println(location));
        System.out.println(locationSearchEngine
                .filterLocations(locationList, location -> !location.equals(moskva)));

        double baseLatitude = 37.4220;
        double baseLongitude = -122.0841;

        List<Double> distances = locationSearchEngine.calculateDistance(locationList, (location) -> {
            double latitudeDiff = Math.abs(location.getLatitude() - baseLatitude);
            double longitudeDiff = Math.abs(location.getLongitude() - baseLongitude);
            return Math.sqrt(Math.pow(latitudeDiff, 2) + Math.pow(longitudeDiff, 2));
        });
        System.out.println(distances);
    }
}
