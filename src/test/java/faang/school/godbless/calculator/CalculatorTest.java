package faang.school.godbless.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static faang.school.godbless.Application.calculate;

public class CalculatorTest {

    private Calculator addition;
    private Calculator subtraction;
    private Calculator product;
    private Calculator division;

    private List<Integer> nums;

    @BeforeEach
    void setUp() {
        addition = Integer::sum;
        subtraction = (x, y) -> x - y;
        product = (x, y) -> x * y;
        division = (x, y) -> x / y;

        nums = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    }

    @Test
    @DisplayName("Arithmetic operations")
    void testCalculate() {
        Integer expectedSum =  nums.stream().reduce(nums.get(0), Integer::sum);
        Integer expectedDiff = nums.stream().reduce(nums.get(0),(a, b) -> a - b);
        Integer expectedProduct = nums.stream().reduce(1, (a, b) -> a * b);
        Integer expectedDivision = nums.stream().mapToInt(Integer::valueOf).reduce((a, b) -> a / b).orElse(0);

        Assertions.assertEquals(expectedSum, calculate(nums, addition));
        Assertions.assertEquals(expectedDiff, calculate(nums, subtraction));
        Assertions.assertEquals(expectedProduct, calculate(nums, product));
        Assertions.assertEquals(expectedDivision, calculate(nums, division));
    }
}
