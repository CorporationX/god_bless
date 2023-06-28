package bc641;

import LambdaStream.bc641.CalculatorMachine;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorMachineTest {

    List<Integer> nums;

    @BeforeEach
    void setUp() {
        nums = List.of(5, 10, 7, 2, -5, 1, 5, -50);
    }

    @Test
    public void productTest() {
        Assertions.assertEquals(875_000, CalculatorMachine.product(nums));
    }

    @Test
    public void sumTest() {
        assertEquals(-25, CalculatorMachine.sum(nums));
    }

    @Test
    public void testIllegalArgumentException() {
        nums = List.of(1);
        assertThrows(IllegalArgumentException.class, () -> CalculatorMachine.product(nums));
    }


}