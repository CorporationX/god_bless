package weasley;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Chore implements Runnable {
    private final String title;

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.printf("Задача %s выполнена потоком %s.%n", title, Thread.currentThread().getName());
        } catch (InterruptedException e) {
            System.out.printf("Задача %s была прервана.", title);
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}
