package faang.school.godbless.TheBigBangTheory;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class Task implements Runnable {
    private String name;
    private String task;
    private final Random random = new Random();

    @Override
    public void run() {
        System.out.println("Начинается выполнение задачи " + name + " - " + task);
        try {
            Thread.sleep(random.nextInt(1000, 10000));
        } catch (InterruptedException e) {
            System.out.println("Задача " + name + " не выполнилась!");
            return;
        }
        System.out.println("Задача " + name + " выполнена!");

    }
}
