package school.faang.BJS2_57708;

import java.util.function.BiFunction;

public class Fares {
    private static final double ECONOMY_DISTANCE_FACTOR = 1.0;
    private static final double ECONOMY_TIME_FACTOR = 0.5;
    private static final double COMFORT_DISTANCE_FACTOR = 1.5;
    private static final double COMFORT_TIME_FACTOR = 0.8;
    private static final double PREMIUM_DISTANCE_FACTOR = 2.0;
    private static final double PREMIUM_TIME_FACTOR = 1.5;

    public static BiFunction<Double, Double, Double> economyFare() {
        return (distance, time) ->
                ECONOMY_DISTANCE_FACTOR * distance + ECONOMY_TIME_FACTOR * time;
    }

    public static BiFunction<Double, Double, Double> comfortFare() {
        return (distance, time) ->
                COMFORT_DISTANCE_FACTOR * distance + COMFORT_TIME_FACTOR * time;
    }

    public static BiFunction<Double, Double, Double> premiumFare() {
        return (distance, time) ->
                PREMIUM_DISTANCE_FACTOR * distance + PREMIUM_TIME_FACTOR * time;
    }
}
