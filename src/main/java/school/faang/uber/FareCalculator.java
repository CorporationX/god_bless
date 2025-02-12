package school.faang.uber;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.BiFunction;

public class FareCalculator {
    private static final Logger logger = LoggerFactory.getLogger(FareCalculator.class);

    public double calculateFare(double distance, double time, BiFunction<Double, Double, Double> total) {
        checkDistance(distance);
        checkTeme(time);
        return total.apply(distance, time);
    }

    public void checkDistance(double distance) {
        if (distance == 0.0) {
            logger.error("The distance should be more than 0.0");
        }
    }

    public void checkTeme(double time) {
        if (time == 0.0) {
            logger.error("The time must be greater than 0.0");
        }
    }
}