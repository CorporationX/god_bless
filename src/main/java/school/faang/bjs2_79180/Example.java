package school.faang.bjs2_79180;

public class Example {
    public static void reverse(int[] numbers) {
        if (numbers.length < 2) {
            return;
        }

        for (int i = 0; i < numbers.length / 2; i++) {
            int temp = numbers[i];
            numbers[i] = numbers[numbers.length - 1 - i];
            numbers[numbers.length - 1 - i] = temp;
        }
    }
}
