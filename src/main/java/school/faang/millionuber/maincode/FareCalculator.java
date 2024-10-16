package school.faang.millionuber.maincode;

import java.util.function.BiFunction;

public class FareCalculator {
    public double calculateFare(double distanse, double travelTime,
                              BiFunction<Double, Double, Double> calculator) {
        return calculator.apply(distanse, travelTime);
    }
}
