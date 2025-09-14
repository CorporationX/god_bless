package school.faang.bjs2_85600_1_1_2_5_turn_around;

import lombok.NoArgsConstructor;

import java.util.Arrays;

@NoArgsConstructor
public class Example {

    public void reverse(int[] array) {

        int[] reverseArray = new int[array.length];
        for (int l = 0, r = array.length - 1; l < r; l++, r--) {
            int temp = array[l];
            array[l] = array[r];
            array[r] = temp;
        }
    }


}
