package school.faang.task_56380;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] numbers = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        System.out.println("Arrays: " + Arrays.toString(numbers));
        Example.reverse(numbers);
        System.out.println("Arrays reverse: " + Arrays.toString(numbers));
    }
}
