package faang.school.godbless.turn_around;

public class Example {

    public static void reverse(int[] numbers) {
        for (int i = 0; i < numbers.length / 2; i++) {
            int tmp = numbers[i];
            numbers[i] = numbers[numbers.length - i - 1];
            numbers[numbers.length - i - 1] = tmp;
        }
        for (int number : numbers) {
            System.out.println(number);
        }
    }
}
