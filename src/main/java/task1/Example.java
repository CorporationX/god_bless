package task1;

public class Example {
    public int[] reverse(int[] numbers) {
        for (int i = 0; i < numbers.length / 2 - 1; i++) {
            int number = numbers[i];
            numbers[i] = numbers[numbers.length - 1 - i];
            numbers[numbers.length - 1 - i] = number;
        }
        return numbers;
    }
}