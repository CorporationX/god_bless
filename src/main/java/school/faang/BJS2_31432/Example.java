package school.faang.BJS2_31432;

public class Example {
    public static void reverse(int[] numbers) {
        validateArray(numbers);

        for (int i = 0; i < numbers.length / 2; i++) {
            int temp = numbers[i];
            numbers[i] = numbers[numbers.length - 1 - i];
            numbers[numbers.length - 1 - i] = temp;
        }
    }

    private static void validateArray(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Invalid array.");
        }
    }
}
