package faang.school.godbless.reverse;

public class Example {
    public static void reverse(int[] numbers) {
        for (int i = 0; i < numbers.length / 2; i++) {
            int temp = numbers[i];
            int index = numbers.length - 1 - i;
            numbers[i] = numbers[index];
            numbers[index] = temp;
        }
    }
}
