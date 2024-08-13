package faang.school.godbless.BJS2_21714;

import java.util.function.BiFunction;

public class FareCalculator {

    public double calculateFare(double distance, double time, BiFunction<Double, Double, Double> economyFare){

        return economyFare.apply(distance, time);
    }
}
