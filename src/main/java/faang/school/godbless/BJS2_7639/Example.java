package faang.school.godbless.BJS2_7639;

import java.util.stream.IntStream;

public class Example {
  public static int[] reverse(int[] nums) {
    int[] result = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      result[nums.length - i - 1] = nums[i];
    }
    return result;
  }
}
