package school.faang.weasley;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Chore implements Runnable {
    private final String title;

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " выполняет задачу: " + title);
            Thread.sleep(1000);
            System.out.println("Задача - " + title + " - выполнена!");
        } catch (InterruptedException e) {
            System.out.println("Задача - " + title + " была прервана.");
            Thread.currentThread().interrupt();
        }
    }
}