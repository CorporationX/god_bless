package school.faang.bjs_79216;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

@Slf4j
public class Example {

    public static void reverse(int[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException("Массив не может быть null");
        }

        log.info("До разворота: {}", Arrays.toString(nums));

        int leftIndex = 0;
        int rightIndex = nums.length - 1;

        while (leftIndex < rightIndex) {
            int temp = nums[leftIndex];
            nums[leftIndex] = nums[rightIndex];
            nums[rightIndex] = temp;

            leftIndex++;
            rightIndex--;
        }

        log.info("После разворота: {}", Arrays.toString(nums));
    }

}