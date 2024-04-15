package faang.school.godbless.TheBigBangTheory;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class Task implements Runnable {
    private String name;
    private String task;

    @Override
    public void run() {
        System.out.println("Начинается выполнение задачи " + name + " - " + task);
        try {
            Thread.sleep(new Random().nextInt(1000, 10000));
        } catch (InterruptedException e) {
            System.out.println("Задача " + name + " не выполнилась!");
        }
        System.out.println("Задача " + name + " выполнена!");

    }
}
