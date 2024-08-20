package faang.school.godbless.sprint3.weasleyFamily;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class Chore implements Runnable {
    private String chore;

    @Override
    public void run() {
        System.out.printf("Начало задачи %s, поток - %s%n", chore, Thread.currentThread().getName());
        try {
            Thread.sleep(new Random().nextInt(1, 6) * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Задача %s выполнена, поток - %s%n", chore, Thread.currentThread().getName());
    }
}
