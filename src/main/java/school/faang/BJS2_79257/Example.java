package school.faang.BJS2_79257;

public class Example {
    public static void reverse(int[] numbers) {
        for (int start = 0, end = numbers.length - 1; end >= start; start++, end--) {
            var temp = numbers[start];
            numbers[start] = numbers[end];
            numbers[end] = temp;
        }
    }
}
