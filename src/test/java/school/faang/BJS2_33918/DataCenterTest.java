package school.faang.BJS2_33918;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DataCenterTest {
    private final List<Integer> NUMBERS = List.of(1, 2, 3, 4, 5);

    @Test
    void sumTest() {
        int result = DataCenter.sum(NUMBERS);

        assertEquals(15, result);
    }

    @Test
    void productTest() {
        int result = DataCenter.product(NUMBERS);

        assertEquals(120, result);
    }

    @Test
    void subtractionTest() {
        int result = DataCenter.calculate(NUMBERS, (a, b) -> (int) a - (int) b);

        assertEquals(-13, result);
    }
}
