package faang.school.godbless.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CalculatorTest {
    private List<Integer> nums;

    @BeforeEach
    void setUp(){
        nums = List.of(3, 2, 2);
    }

    @Test
    void sumTest(){
        int expected = 7;
        int actual = Calculator.sum(nums);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void multiplyTest(){
        int expected = 12;
        int actual = Calculator.multiply(nums);

        Assertions.assertEquals(expected, actual);

    }
}
