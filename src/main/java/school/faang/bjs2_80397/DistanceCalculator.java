package school.faang.bjs2_80397;

import lombok.AllArgsConstructor;

import java.util.function.Function;

@AllArgsConstructor
public class DistanceCalculator implements Function<Location, Double> {

    private final double baseLatitude;
    private final double baseLongitude;

    @Override
    public Double apply(Location location) {
        double latitudeDiff = location.getLatitude() - baseLatitude;
        double longitudeDiff = location.getLongitude() - baseLongitude;
        return Math.sqrt(Math.pow(latitudeDiff, 2) + Math.pow(longitudeDiff, 2));
    }
}