package faang.school.godbless.sprint_3.multithreading.extremly_poor;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class Chore implements Runnable {
    private String chore;

    @Override
    public void run() {
        System.out.printf("Начинаю выполнение задачи %s%n", chore);
        String name = Thread.currentThread().getName();
        try {
            int workTime = new Random().nextInt((3) + 1) * 1000;
            Thread.sleep(workTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Поток: %s выполнен.%n", name);
    }
}
