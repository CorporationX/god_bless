package faang.school.godbless.threads.extremely_poor;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Chore implements Runnable {
    private String chore;

    @Override
    public void run() {
        System.out.printf("Задача %s выполняется потоком %s...\n", chore, Thread.currentThread().getName());
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.printf("Задача %s завершена потоком %s...\n", chore, Thread.currentThread().getName());
    }
}
