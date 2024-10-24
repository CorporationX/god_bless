package Sprint_2.BJS2_34628;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Location> locations = new ArrayList<>(Arrays.asList(
                new Location("Eiffel Tower", 48.8584, 2.2945),
                new Location("Statue of Liberty", 40.6892, -74.0445),
                new Location("Great Wall of China", 40.4319, 116.5704),
                new Location("Sydney Opera House", -33.8568, 151.2153)
        ));

        LocationSearchEngine searchEngine = new LocationSearchEngine();
        List<Location> filteredLocation = searchEngine.filterLocations(locations, location -> location.getLongitude() > 0);
        System.out.println("filteredLocation: " );
        searchEngine.processLocations(filteredLocation, location -> System.out.println(location.getLongitude()));

        double baseLatitude = 37.32323;
        double baseLongitude = -327.32323;

        List<Double> distances = searchEngine.calculateDistances(locations, location -> {
            double latitudeDifference = Math.abs(location.getLongitude() - baseLongitude);
            double longitudeDifference = Math.abs(location.getLongitude() - baseLatitude);
            return Math.sqrt(Math.pow(latitudeDifference, 2) + Math.pow(longitudeDifference, 2));
        });
        System.out.println("Distances from base location:");
        distances.forEach(System.out::println);
    }


}
