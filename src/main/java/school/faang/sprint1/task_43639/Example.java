package school.faang.sprint1.task_43639;

import java.util.Arrays;

public class Example {

    static Number[] reverse(Number[] numbers) {
        Number[] reversedNumbers = new Number[numbers.length];
        for (int i = numbers.length - 1; i >= 0; i--) {
            reversedNumbers[numbers.length - 1 - i] = numbers[i];
        }
        return reversedNumbers;
    }

    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(reverse(new Integer[]{
                        1, 2, 3, 4, 5
                }))
        );
    }
}
