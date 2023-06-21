import faang.school.godbless.uberMillionaires.FareCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.BiFunction;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FareCalculatorTest {
    FareCalculator fareCalculator;
    double distanceRide;
    double timeRide;
    BiFunction<Double, Double, Double> biFunction;
    @BeforeEach
    public void init() {
        fareCalculator = new FareCalculator();
        biFunction = (distanceRide, timeRide) -> 1.0 * distanceRide + 0.5 * timeRide;
        distanceRide = 10.0;
        timeRide = 15.0;
    }

    @Test
    public void fareCalculatorTest() {
        double costRide = fareCalculator.calculateFare(distanceRide, timeRide, biFunction);
        double expected = 17.5;
        assertEquals(expected, costRide);
    }
}

