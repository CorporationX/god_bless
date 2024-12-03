package school.faang;

import java.util.Arrays;

import static java.util.Collections.reverse;

public class Example {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};

        reverse(nums);
    }

    public static void reverse(int[] nums){
        if(nums.length == 0){
                    System.out.println("Массив пуст");
        } else {
            for(int i = 0; i < nums.length / 2; i++){
                int temp = nums[i];
                nums[i] = nums[nums.length - i - 1];
                nums[nums.length - i - 1] = temp;
            }
            System.out.println("nums:" + Arrays.toString(nums));
        }
    }
}

