package school.faang.bjs2_73082;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Chore implements Runnable {
    private final String name;

    @Override
    public void run() {
        try {
            System.out.printf("Началось выполнение задачи '%s'. Поток %s%n", name, Thread.currentThread().getName());
            Thread.sleep(1000);
            System.out.printf("Выполнение задачи '%s' завершено'. Поток %s%n", name, Thread.currentThread().getName());
        } catch (InterruptedException e) {
            System.out.printf("Thread %s was interrupted%n", Thread.currentThread().getName());
            Thread.currentThread().interrupt();
        }
    }
}
