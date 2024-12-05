package school.faang.sprint_1.task_43644;

public class Example {
    public static void revers(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new IllegalArgumentException("Array must not be empty or null!");
        }
        for (int i = 0; i < numbers.length / 2; i++) {
            int x = numbers[i];
            numbers[i] = numbers[numbers.length - i - 1];
            numbers[numbers.length - i - 1] = x;
        }
    }
}