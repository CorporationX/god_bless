package faang.school.godbless.sprint_1.task_43686;

public class Example {
    public void revers(int[] numbers) {
        if (numbers == null) {
            System.out.println("Массив не должен быть null!");
            return;
        }

        if (numbers.length < 1) {
            System.out.println("Массив не должен быть пустым!");
            return;
        }

        for (int i = 0, j = numbers.length - 1; i < j; i++, j--) {
            int number = numbers[i];
            numbers[i] = numbers[j];
            numbers[j] = number;
        }
    }
}
