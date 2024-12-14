package the_big_bang_theory;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class Task implements Runnable {

    private String performerName;
    private String task;

    @Override
    public void run() {
        try {
            System.out.printf("Задача %s начала выполнятся. Исполнитель: %s%n", task, performerName);
            Thread.sleep(new Random().nextLong(1, 5));
            System.out.printf("Задача %s завершена%n", task);
        } catch (InterruptedException e) {
            System.out.printf("Задача %s прекратила свое выполнение%n", task);
            Thread.currentThread().interrupt();
        }
    }
}
