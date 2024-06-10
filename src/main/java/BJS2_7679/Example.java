package BJS2_7679;

import lombok.ToString;

@ToString
public class Example {
    public int[] reverse(int[] nums) {
        int[] newArray = new int[nums.length];
        int count = nums.length;

        for (int numbers : nums) {
            newArray[count - 1] = numbers;
            count--;
        }
        return newArray;
    }
}