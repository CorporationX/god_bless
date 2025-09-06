package school.faang;

import lombok.ToString;

import java.util.Arrays;

public class Example {

    public void reverseIt(int[] integers){
        int left = 0;
        int right = integers.length-1;

        while(left<right){
            int temp = integers[left];
            integers[left] = integers[right];
            integers[right] = temp;
            left++;
            right--;
        }

        System.out.println(Arrays.toString(integers));
    }
}
