package faang.school.godbless.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {

    private List<Integer> list;
    private List<Integer> emptyList;

    @BeforeEach
    public void setUp() {
        list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 10));
        emptyList = new ArrayList<>(Arrays.asList());
    }

    @Test
    public void testCalculateSum() {
        assertEquals(20, CalculatorAction.sum(list));
    }

    @Test
    public void testCalculateProduct() {
        assertEquals(240, CalculatorAction.product(list));
    }

    @Test
    public void testThrowException() {
        assertThrows(IllegalArgumentException.class, () -> CalculatorAction.sum(emptyList));
    }
}
