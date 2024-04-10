package faang.school.godbless.BJS2_5130;

import java.util.List;

public class Main {
  public static void main(String[] args) {
    List<Integer> nums = List.of(1, 2, 3, 4);
    System.out.println(product(nums));
    System.out.println(sum(nums));
  }

  public static int calculate(List<Integer> nums, Calculator calculator) throws IllegalArgumentException {
    int result = nums.get(0);
    for(int i = 1; i < nums.size(); i++) {
      result = calculator.calculate(result, nums.get(i));
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
