package school.faang.extremelypoor;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Chore implements Runnable {
    private static final int TASK_DURATION_MS = 500;
    private final String title;

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " выполняет задачу: " + title);
            Thread.sleep(TASK_DURATION_MS);
            System.out.println(title + " выполнена!");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Задача была прервана: " + title);
            throw new RuntimeException(e);
        }
    }
}
