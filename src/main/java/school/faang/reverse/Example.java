package school.faang.reverse;

public class Example {
    public static int[] reverse(int[] numbers) {
        int[] newNumbers = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            newNumbers[i] = numbers[numbers.length - i - 1];
        }
        return newNumbers;
    }
}