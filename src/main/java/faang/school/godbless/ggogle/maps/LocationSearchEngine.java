package faang.school.godbless.ggogle.maps;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LocationSearchEngine {
    public List<Location> filterLocations (List<Location> locationList, Predicate<Location> locationPredicate) {
        List<Location> locations = new ArrayList<>();
        for (int i = 0; i < locationList.size(); i++) {
            if (locationPredicate.test(locationList.get(i))) {
                locations.add(locationList.get(i));
            }
        }
        return locations;
    }
    public void processLocations (List<Location> locationList, Consumer<Location> locationConsumer) {
        locationList.forEach(locationConsumer);
    }
    public List<Double> calculateDistances (List<Location> locationList, Function<Location, Double> locationDoubleFunction) {
        List<Double> distanceList = new ArrayList<>();
        for (int i = 0; i < locationList.size(); i++) {
            distanceList.add(locationDoubleFunction.apply(locationList.get(i)));
        }
        return  distanceList;
    }
}
