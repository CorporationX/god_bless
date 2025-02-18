package school.faang.verynicebut;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Chore implements Runnable {
    private final String title;

    @Override
    public void run() {
        try {
            System.out.printf("Выполняем задачу %s в потоке %s\n", title, Thread.currentThread().getName());
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e.getMessage());
        }

    }
}
