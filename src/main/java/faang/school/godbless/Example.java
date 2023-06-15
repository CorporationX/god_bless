package faang.school.godbless;

public class Example {
    public static int[] reverse(int[] numbers) {
        for (int i = 0, j = numbers.length - 1; i < j; i++, j--) {
            int left = numbers[i];
            numbers[i] = numbers[j];
            numbers[j] = left;
        }
        return numbers;
    }
}
