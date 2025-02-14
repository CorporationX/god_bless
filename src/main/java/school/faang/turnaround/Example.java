package school.faang.turnaround;

public class Example {
    public static int[] reverse(int[] numbers) {
        int[] reversed = new int[numbers.length];
        int end = numbers.length - 1;
        for (int number : numbers) {
            reversed[end] = number;
            end--;
        }
        return reversed;
    }
}
