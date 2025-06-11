package school.faang.uber;

import java.util.function.DoubleBinaryOperator;

/**
 * @author Danil Pudovkin
 * @since 11.06.2025
 */
public class FareCalculator {

    public double calculateFare(double distance, double time, DoubleBinaryOperator calculator) {
        return calculator.applyAsDouble(distance, time);
    }
}
