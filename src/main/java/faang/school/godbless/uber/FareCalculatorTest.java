package faang.school.godbless.uber;

import org.junit.Test;

import java.util.function.BiFunction;
public class FareCalculatorTest {
    @Test(expected = IllegalArgumentException.class)
    public void testCalculateFareWithNegativeDistance() {
        FareCalculator fareCalculator = new FareCalculator();
        double distance = -10.0;
        double time = 15.0;

        BiFunction<Double, Double, Double> fare = (distanceTest, timeTest) -> 1.0 * distanceTest + 0.5 * timeTest;

        fareCalculator.calculateFare(distance, time, fare);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCalculateFareWithNegativeTime() {
        FareCalculator fareCalculator = new FareCalculator();
        double distance = 10.0;
        double time = -15.0;

        BiFunction<Double, Double, Double> fare = (distanceTest, timeTest) -> 1.0 * distanceTest + 0.5 * timeTest;

        fareCalculator.calculateFare(distance, time, fare);
    }

}