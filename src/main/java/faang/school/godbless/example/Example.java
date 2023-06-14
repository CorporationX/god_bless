package faang.school.godbless.example;

import java.util.List;

public class Example {
  private void reverseElements(List<Integer> nums, int left, int right) {
    int temp = nums.get(left);
    nums.set(left,  nums.get(right));
    nums.set(right,  temp);
  }
  public List<Integer> reverse(List<Integer> nums) {
    int left = 0;
    int right = nums.size() - 1;

    while (left < right) {
      reverseElements(nums, left, right);
      left++;
      right--;
    }

    return nums;
  }
}
