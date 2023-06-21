package faang.school.godbless.kxnvg.maps;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LocationSearchEngine {

    public List<Location> filterLocations(List<Location> locations, Predicate<Location> predicate) {
        List<Location> resultList = new ArrayList<>();

        locations.forEach((location) -> {
            if (predicate.test(location)) {
                resultList.add(location);
            }
        });
        return resultList;
    }

    public void processLocations(List<Location> locations, Consumer<Location> consumer) {
        locations.forEach(consumer::accept);
    }

    public List<Double> calculateDistances(List<Location> locations, Function<Location, Double> function) {
        List<Double> resultList = new ArrayList<>();

        locations.forEach((location) -> {
            resultList.add(function.apply(location));
        });
        return resultList;
    }
}
