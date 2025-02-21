package school.faang.extremelypoor;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Chore implements Runnable {
    private final String title;

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " выполняет задачу: " + title);
            Thread.sleep(500);
            System.out.println(title + " выполнена!");
        } catch (InterruptedException e) {
            System.out.println("Задача " + title + " была остановлена.");
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}
