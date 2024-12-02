package school.faang.task_43620;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] reverseArray = {1, 2, 3, 4, 5};
        System.out.println("nums: " + Arrays.toString(reverseArray));
        Example.reverse(reverseArray);
        System.out.println("reverse nums: " + Arrays.toString(reverseArray));
    }
}