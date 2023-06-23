package faang.school.godbless.sprint3.Uber;

import org.junit.jupiter.api.Test;

import java.util.function.BiFunction;

import static org.junit.jupiter.api.Assertions.*;

class FareCalculatorTest {
    FareCalculator fareCalculator = new FareCalculator();
    @Test
    void testCalculateFareZero() {
        BiFunction<Double, Double, Double> test = (distance, time) -> 1.0 * distance + 1.0 * time;
        assertEquals(5, fareCalculator.calculateFare(0,0,test));
    }

    @Test
    void testCalculateFareBasic() {
        BiFunction<Double, Double, Double> test = (distance, time) -> 1.0 * distance + 1.0 * time;
        assertEquals(10, fareCalculator.calculateFare(5,5,test));
    }

    
}