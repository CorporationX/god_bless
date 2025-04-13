package school.faang.bjs268203;

public class Example {
    public static void reverse(Integer[] numbers) {
        if (numbers == null || numbers.length <= 1) {
            return;
        }

        for (int i = 0, j = numbers.length - 1; i < j; i++, j--) {
            int leftNumber = numbers[i];
            int rightNumber = numbers[j];
            numbers[i] = rightNumber;
            numbers[j] = leftNumber;
        }
    }
}
