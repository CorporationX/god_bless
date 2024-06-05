package faang.school.godbless;

public class Example {
    public static void reverse(int[] numbers) {
        int n = numbers.length % 2 == 0 ? numbers.length / 2 - 1 : numbers.length / 2;

        for (int i = 0; i < n; i++) {
            int temp = numbers[i];
            numbers[i] = numbers[numbers.length - 1 - i];
            numbers[numbers.length - 1 - i] = temp;
        }
    }
}
