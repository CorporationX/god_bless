package school.faang.sprint_1.task_bjs243608;

import java.util.Arrays;

public class Example {

    public static int[] reverse(int[] array) {
        int leftIndex = 0;
        int rightIndex = array.length - 1;
        while (leftIndex < rightIndex) {
            int temp = array[leftIndex];
            array[leftIndex++] = array[rightIndex];
            array[rightIndex--] = temp;
        }
        return array;
    }

    public static void main(String[] args) {
        int[] testArray1 = {1, 2, 3, 4, 5};
        int[] testArray2 = {1, -2, 3, 4, 5, -6};
        int[] testArray3 = {};
        System.out.println(Arrays.toString(reverse(testArray1)));
        System.out.println(Arrays.toString(reverse(testArray2)));
        System.out.println(Arrays.toString(reverse(testArray3)));
    }
}
