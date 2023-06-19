package calculator;

import faang.school.godbless.calculator.Calculator;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
  @Test
  public void calculateTest() {
    List<Integer> nums = List.of(10, 3, 2, 1);
    int expectedResult = 10 - 3 - 2 - 1;
    assertEquals(expectedResult, Calculator.calculate(nums, (int a, int b) -> a - b));
  }

  @Test
  public void productTest() {
    List<Integer> nums = List.of(10, 3, 2, 1);
    int expectedResult = 10 * 3 * 2;
    assertEquals(expectedResult, Calculator.product(nums));
  }

  @Test
  public void sumTest() {
    List<Integer> nums = List.of(10, 3, 2, 1);
    int expectedResult = 10 + 3 + 2 + 1;
    assertEquals(expectedResult, Calculator.sum(nums));
  }
}
