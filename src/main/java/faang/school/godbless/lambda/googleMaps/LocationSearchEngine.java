package faang.school.godbless.lambda.googleMaps;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LocationSearchEngine {
    public List<Location> filterLocations(List<Location> locationList, Predicate<Location> predicate) throws IllegalArgumentException {
        if (locationList == null) {
            throw new IllegalArgumentException("������ ������� ����� null!");
        }

        List<Location> locations = new ArrayList<>();
        for (Location location : locationList) {
            if (predicate.test(location)) {
                locations.add(location);
            }
        }

        return locations;
    }

    public void processLocations(List<Location> locationList, Consumer<Location> consumer) throws IllegalArgumentException {
        if (locationList == null) {
            throw new IllegalArgumentException("������ ������� ����� null!");
        }

        locationList.forEach(consumer);
    }

    public List<Double> calculateDistances(List<Location> locationList, Function<Location, Double> function) throws IllegalArgumentException{
        if (locationList == null) {
            throw new IllegalArgumentException("������ ������� ����� null!");
        }

        List<Double> listOfDistances = new ArrayList<>();
        for (Location location : locationList) {
            listOfDistances.add(function.apply(location));
        }

        return listOfDistances;
    }
}
