package bjs2_89618;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Chore implements Runnable {
    private static final int TASK_DURATION_MS = 1000; // время выполнения задачи в миллисекундах

    private final String chore;

    @Override
    public void run() {
        try {
            System.out.println(String.format("%s выполняет задачу: %s",
                    Thread.currentThread().getName(), chore));

            Thread.sleep(TASK_DURATION_MS); // имитация выполнения

            System.out.println(String.format("✅ %s выполнена!", chore));
        } catch (InterruptedException e) {
            System.out.println(String.format("Задача %s была прервана.", chore));
            Thread.currentThread().interrupt();
        }
    }
}