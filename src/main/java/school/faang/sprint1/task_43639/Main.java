package school.faang.sprint1.task_43639;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Integer[] numbers = new Integer[]{
                1, 2, 3, 4
        };
        Example.reverse(numbers);
        System.out.println(Arrays.toString(numbers));
    }
}
