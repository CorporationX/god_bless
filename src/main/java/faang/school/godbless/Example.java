package faang.school.godbless;

import java.lang.reflect.Array;

public class Example {
    public void convert(int[] input){
        int left = 0;
        int right = input.length - 1;

        while (left < right) {
            int temp = input[left];
            input[left] = input[right];
            input[right] = temp;

            left++;
            right--;
        }

    }
}
