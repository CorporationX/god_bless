package faang.school.godbless.sprint3.theBigBangTheorе;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class Task implements Runnable {
    private final String name;
    private String task;

    @Override
    public void run() {
        System.out.printf("%s начал выполнение \"%s\"%n", name, task);
        try {
            Thread.sleep(new Random().nextInt(1, 6) * 1000L);
        } catch (InterruptedException e) {
            System.out.println("Задача прервана");
        }
        System.out.printf("%s выполнил задачу \"%s\"%n", name, task);
    }
}
