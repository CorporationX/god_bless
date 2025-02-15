package school.faang.turnaround;

public class Example {
    public static int[] reverse(int[] numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException("The array is null");
        }
        if (numbers.length == 0) {
            throw new IllegalArgumentException("The array is empty");

        }
        int rightIndex = numbers.length - 1;
        int temporary;
        for (int i = 0; i < numbers.length / 2; i++) {
            temporary = numbers[i];
            numbers[i] = numbers[rightIndex];
            numbers[rightIndex] = temporary;
            rightIndex--;
        }
        return numbers;
    }
}
