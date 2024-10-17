package school.faang.BJS2_34385_MillionsOfUber;

import java.util.function.BiFunction;

public class FareCalculator {
    public double calculateFare(double distance, double time, BiFunction<Double, Double, Double> pricingLogic) {
        return pricingLogic.apply(distance, time);
    }
}
