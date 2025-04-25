package school.faang.bigbangtheory;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Task implements Runnable {
    private final String name;
    private final String task;

    public void run() {
        System.out.printf("%s начинает задание: %s%n", name, task);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.printf("%s: выполнение задачи \"%s\" было прервано.%n", name, task);
            Thread.currentThread().interrupt();
        }
        System.out.printf("%s завершил задание: %s%n", name, task);
    }
}