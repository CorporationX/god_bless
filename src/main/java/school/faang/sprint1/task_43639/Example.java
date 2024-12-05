package school.faang.sprint1.task_43639;


public class Example {

    static void reverse(Number[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return;
        }
        for (int i = numbers.length - 1; i >= numbers.length / 2; i--) {
            Number left = numbers[numbers.length - 1 - i];
            numbers[numbers.length - 1 - i] = numbers[i];
            numbers[i] = left;
        }
    }
}
