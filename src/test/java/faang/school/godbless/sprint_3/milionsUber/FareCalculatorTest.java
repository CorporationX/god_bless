package faang.school.godbless.sprint_3.milionsUber;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.function.BiFunction;

import static org.junit.jupiter.api.Assertions.*;

class FareCalculatorTest {
    FareCalculator fareCalculator;
    BiFunction<Double, Double, Double> firstPrice;
    BiFunction<Double, Double, Double> secondPrice;

    @BeforeEach
    public void init() {
        fareCalculator = new FareCalculator();
        firstPrice = ((distance, time) -> distance * (time * 1.5));
        secondPrice = ((distance, time) -> distance * (time / 1.5));
    }

    @Test
    public void calculateFareTest() {
        double expected = 13.5;
        double firstResult = fareCalculator.calculateFare(3.0, 3.0, firstPrice);

        assertEquals(expected, firstResult);
        assertThrows(IllegalStateException.class, () -> fareCalculator.calculateFare(0.0, 0.0, firstPrice));
        assertThrows(IllegalStateException.class, () -> fareCalculator.calculateFare(0.0, 0.0, secondPrice));

    }
}