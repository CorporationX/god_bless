package faang.school.godbless.fareCalculator;

import faang.school.godbless.sprint2.uber.FareCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.BiFunction;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class fareCalculatorTest {
    FareCalculator fareCalculator;
    BiFunction<Double, Double, Double> economyFare;
    double distance;
    double time;

    @BeforeEach
    public void init() {
        fareCalculator = new FareCalculator();
        economyFare = (distance, time) -> 1.0 * distance + 0.5 * time;
        distance = 10.0;
        time = 15.0;
    }

    @Test
    public void fareCalculatorTest() {
        double tripCost = fareCalculator.calculateFare(distance, time, economyFare);
        double expected = 17.5;
        assertEquals(expected, tripCost);
    }
}
