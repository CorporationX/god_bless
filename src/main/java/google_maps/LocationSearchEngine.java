package google_maps;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LocationSearchEngine {
    /**
     * Searches for locations in the given list which satisfy the given filter.
     *
     * @param locations the list of locations to search in
     * @param filter the filter to check each location against
     * @return a list of locations from the input which satisfy the filter
     */
    public List<Location> filterLocations(List<Location> locations, Predicate<Location> filter) {
        List<Location> foundedLocations = new ArrayList<>();

        for (Location location : locations) {
            if (!filter.test(location)) {
                continue;
            }
            foundedLocations.add(location);
        }

        return foundedLocations;
    }

    /**
     * Process all locations in the given list using the given worker function.
     *
     * @param locations the list of locations to process
     * @param worker the function to run on each location
     */
    public void processLocations(List<Location> locations, Consumer<Location> worker) {
        locations.forEach(worker);
    }

    /**
     * Calculates a list of distances from a fixed point (e.g. the location of the user)
     * to each location in the given list.
     *
     * @param locations the list of locations to calculate distances to
     * @param fnc a function which takes a location and returns its distance to some fixed point
     * @return a list of distances from the fixed point to each location in the input list
     */
    public List<Double> calculateDistances(List<Location> locations, Function<Location, Double> fnc) {
        List<Double> distance = new ArrayList<>();

        for (Location location : locations) {
            distance.add(fnc.apply(location));
        }

        return distance;
    }
}
