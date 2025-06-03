package school.faang.bjs_79216;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class Example {

    public static void reverse(int[] nums) {
        log.info("До разворота: {}", Arrays.toString(nums));

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

            left++;
            right--;
        }

        log.info("После разворота: {}", Arrays.toString(nums));
    }

}