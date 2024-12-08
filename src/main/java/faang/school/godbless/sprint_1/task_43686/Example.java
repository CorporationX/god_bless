package faang.school.godbless.sprint_1.task_43686;

public class Example {
    public void revers(int[] numbers) {
        for (int i = 0, j = numbers.length - 1; i < j; i++, j--) {
            int number = numbers[i];
            numbers[i] = numbers[j];
            numbers[j] = number;
        }
    }
}
