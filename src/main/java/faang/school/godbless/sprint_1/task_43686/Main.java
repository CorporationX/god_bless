package faang.school.godbless.sprint_1.task_43686;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Example example = new Example();

        int[] numbers = new int[] {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(numbers));

        example.revers(numbers);
        System.out.println(Arrays.toString(numbers));
    }
}
