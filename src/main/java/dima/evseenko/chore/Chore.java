package dima.evseenko.chore;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Random;

@Getter
@RequiredArgsConstructor
public class Chore implements Runnable {
    private final String chore;

    @Override
    public void run() {
        System.out.printf("Выполнение задачи %s в потоке %s%n", chore, Thread.currentThread().getName());
        try {
            Thread.sleep(new Random().nextInt(5000 - 1000) + 1000);
            System.out.printf("Задача %s выполнена в потоке %s%n", chore, Thread.currentThread().getName());
        } catch (InterruptedException e) {
            System.out.printf("Ошибка выполнения задачи %s в потоке %s%n", chore, Thread.currentThread().getName());
            throw new RuntimeException(e);
        }
    }
}
