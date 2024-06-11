package faang.school.godbless.BJS2_8989;

import java.util.List;

public class Main {
  public static void main(String[] args) {
    List<Integer> nums = List.of(1, 2, 3, 4);
    System.out.println(product(nums));
    System.out.println(sum(nums));
  }

  public static int calculate(List<Integer> nums, Calculator calculator) throws IllegalArgumentException {
    if (nums.isEmpty() || calculator == null) {
      throw new IllegalArgumentException("В метод переданы пустые значения");
    }
    return nums.stream().reduce(calculator::calculate).orElse(0);
  }

  public static int product(List<Integer> nums) {
    return calculate(nums, (x, y) -> x * y);
  }

  public static int sum(List<Integer> nums) {
    return calculate(nums, Integer::sum);
  }
}
