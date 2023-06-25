package faang.school.godbless;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    @ParameterizedTest
    @MethodSource("providedTestData")
    public void calculate_ShouldApplyOpertaionToAllElements(List<Integer> nums, Calculator<Integer> calculator, int expected){
        int result = Calculator.calculate(nums, calculator);
    }
}