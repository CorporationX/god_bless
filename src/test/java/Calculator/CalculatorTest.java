package Calculator;

import org.junit.jupiter.api.Test;

import java.util.List;

import static faang.school.godbless.Calculator.Application.product;
import static faang.school.godbless.Calculator.Application.sum;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
    @Test
    public void calculateTest() {
        List<Integer> nums = List.of(1, 2, 3, 4, 5);

        int product = product(nums);
        int sum = sum(nums);

        assertEquals(15, sum);
        assertEquals(120, product);
    }
}
