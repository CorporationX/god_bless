package faang.school.godbless.BJS2_18974;

import java.util.Arrays;

public class Example {

     public static void reverse(int[] array) {
         for (int i = 0; i < array.length / 2; i++){
             int temp = array[i];
             array[i] = array[array.length - 1 - i];
             array[array.length - 1 - i] = temp;
         }
         System.out.println(Arrays.toString(array));
     }

    public static void main(String[] args) {
        int[] bound = new int[]{1,2,3,4,5};
        reverse(bound);
    }
}
