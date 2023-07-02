package faang.school.godbless.Google_Maps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LocationSearchEngine {

    public List<Location> filterLocations(List<Location> locationsList, Predicate<Location> locationPredicate){
        List<Location> resultList = new ArrayList<>();
        for (Location location: locationsList) {
            if (locationPredicate.test(location)){
                resultList.add(location);
            }
        }
        return resultList;
    }

    public void processLocations(List<Location> locationsList, Consumer<Location> locationConsumer){
        for (Location location: locationsList) {
            locationConsumer.accept(location);
        }
    }

    public Map<Location, Double> calculateDistances(List<Location> locationsList, Function<Location, Double> function){
        Map<Location, Double> resultHashMap = new HashMap<>();
        for (Location location: locationsList) {
            resultHashMap.put(location,function.apply(location));
        }
        return resultHashMap;
    }
}

