package faang.school.godbless.sprint3.task10;

import faang.school.godbless.sprint3.lambda.task10.FareCalculator;
import org.junit.jupiter.api.Test;

import java.util.function.BiFunction;

import static org.junit.jupiter.api.Assertions.*;

class FareCalculatorTest {

    @Test
    void testCalculateFare() {
        BiFunction<Double, Double, Double> economyFare = (distance, time) -> 1.0 * distance + 0.5 * time;
        double distance = 10.0;
        double time = 15.0;
        FareCalculator fareCalculator = new FareCalculator();

        double actual = fareCalculator.calculateFare(distance, time, economyFare);

        assertEquals(17.5, actual);
    }

    @Test
    void testValidationIsNull() {
        assertThrows(NullPointerException.class, () -> new FareCalculator().calculateFare(1.2, 3.4, null));
    }

    @Test
    void testValidationIncorrectData() {
        assertThrows(IllegalArgumentException.class, () -> new FareCalculator().calculateFare(-1, 3.4, null));
    }
}