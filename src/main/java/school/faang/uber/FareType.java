package school.faang.uber;

import lombok.Getter;

import java.util.function.BiFunction;

@Getter
public enum FareType {
    ECONOMY(1.0, 0.3),
    COMFORT(1.5, 0.5),
    COMFORT_PLUS(2.0, 0.7),
    BUSINESS(2.5, 1.0);

    private final BiFunction<Double, Double, Double> fareFunction;

    FareType(double distanceRate, double timeRate) {
        this.fareFunction = (distance, time) -> distanceRate * distance + timeRate * time;
    }
}
