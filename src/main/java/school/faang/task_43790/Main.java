package school.faang.task_43790;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[] numbers = {1, 2, 3, 4, 5};

        System.out.println("Original Array: " + Arrays.toString(numbers));
        Example.reverse(numbers);
        System.out.println("Reversed Array: " + Arrays.toString(numbers));
    }
}
