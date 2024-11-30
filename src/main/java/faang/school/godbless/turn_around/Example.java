package faang.school.godbless.turn_around;

public class Example {
    public int[] reverse(int[] numbers) {
        for (int i = 0; i < numbers.length / 2; i++) {
            int j = numbers[i];
            numbers[i] = numbers[numbers.length - i - 1];
            numbers[numbers.length - i - 1] = j;
        }
        return numbers;
    }
}
