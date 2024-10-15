package school.faang.firstStream.BJS2_31459;


public class Example {
    public static int[] reverse(int[] numbers) {
        for (int i = 0; i < numbers.length / 2; i++) {
            numbers[i] += numbers[numbers.length - 1 - i];
            numbers[numbers.length - 1 - i] = numbers[i] - numbers[numbers.length - 1 - i];
            numbers[i] -= numbers[numbers.length - 1 - i];
        }
        return numbers;
    }
    public static int[] reverseTwo(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            numbers[left] += numbers[right];
            numbers[right] = numbers[left] - numbers[right];
            numbers[left] -= numbers[right];

            left++;
            right--;
        }
        return numbers;
    }
}