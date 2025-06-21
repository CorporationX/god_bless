package school.faang.bjs2_80408;

import lombok.extern.slf4j.Slf4j;
import school.faang.Location;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

@Slf4j
public class LocationSearchEngine {
    public List<Location> filterLocations(List<Location> locationList, Predicate<Location> locationPredicate) {
        if (locationList.isEmpty() || locationList == null) {
            log.warn("Нельзя создать такой список");
        }
        if (locationPredicate == null) {
            log.warn("Не может быть null");
        }

        Iterator<Location> iterator = locationList.iterator();
        while (iterator.hasNext()) {
            Location location = iterator.next();
            if (!locationPredicate.test(location)) {
                iterator.remove();
            }
        }
        return locationList;
    }

    public void processLocations(List<Location> locationList, Consumer<Location> locationConsumer) {
        for (Location location : locationList) {
            locationConsumer.accept(location);
        }
    }

    public List<Double> calculateDistance(List<Location> locationList, Function<Location, Double> distanceFunction) {
        List<Double> result = new ArrayList<>();
        for (Location location : locationList) {
            Double distance = distanceFunction.apply(location);
            result.add(distance);
        }
        return result;
    }
}