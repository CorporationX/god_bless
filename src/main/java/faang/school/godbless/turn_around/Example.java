package faang.school.godbless.turn_around;

public class Example {
    public int[] reverse(int[] numbers) {
        int[] nextNumbers = new int[numbers.length];
        for (int i = 0, j = numbers.length - 1; i < numbers.length; j--, i++) {
            nextNumbers[i] = numbers[j];
        }
        return nextNumbers;
    }
}
