package faang.school.godbless;

public class Example {
  public int[] reverse(int[] nums) {
    int[] result = new int[nums.length];
    for (int i = nums.length - 1, j = 0; i >= 0; i--, j++) {
      result[j] = nums[i];
    }

    return result;
  }
}
