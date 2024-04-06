package faang.school.godbless.BJS2_4588;

public class Example {
    public static int[] reverse(int[] numbers) {
        int[] reversedNumbers = new int[numbers.length];
        int start = 0;
        int end = numbers.length - 1;

        while (start < numbers.length) {
            reversedNumbers[start] = numbers[end];
            start++;
            end--;
        }

        return reversedNumbers;
    }
}
