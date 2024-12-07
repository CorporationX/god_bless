package school.faang.task_43642;

public class Example {

    public static int[] reverse(int[] numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException("Некорректное значение!");
        }

        for (int i = 0; i < numbers.length / 2; i++) {
            int temp = numbers[i];
            numbers[i] = numbers[numbers.length - 1 - i];
            numbers[numbers.length - 1 - i] = temp;
        }

        return numbers;
    }
}
