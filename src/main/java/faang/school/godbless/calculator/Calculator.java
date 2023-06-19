package faang.school.godbless.calculator;

import java.util.List;

public class Calculator {
  public static int calculate(List<Integer> nums, Calculate calculate) throws IllegalArgumentException {
    if (nums.isEmpty()) {
      throw new IllegalArgumentException("empty list");
    }

    int result = nums.get(0);

    for (int i = 1; i < nums.size(); ++i) {
      result = calculate.run(result, nums.get(i));
    }

    return result;
  }

  public static int product(List<Integer> nums) {
    return calculate(nums, (a, b) -> a * b);
  }

  public static int sum(List<Integer> nums) {
    return calculate(nums, Integer::sum);
  }
}
