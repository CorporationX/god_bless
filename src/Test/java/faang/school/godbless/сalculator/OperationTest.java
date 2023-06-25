package faang.school.godbless.ñalculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OperationTest {
    private List<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = List.of(3,4,6,2,1,5,7,4);
    }

    @Test
    void calculate() {
        int actual = Operation.calculate(numbers, ((firstNumber, secondNumber) -> firstNumber + secondNumber));
        assertEquals(32, actual);
    }
}