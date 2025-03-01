package school.faang.task_61083;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Random;

@AllArgsConstructor
@Getter
@ToString
public class Chore implements Runnable {
    private static final int MIN_SLEEP_TIME_MS = 1500;
    private static final int MAX_SLEEP_TIME_MS = 5000;

    private final Random random = new Random();
    private final String title;

    @Override
    public void run() {
        try {
            System.out.printf("Сейчас выполняется задача '%s' в потоке %s%n",
                    title, Thread.currentThread().getName());
            Thread.sleep(random.nextInt(MIN_SLEEP_TIME_MS, MAX_SLEEP_TIME_MS));
            System.out.printf("Задача '%s' выполнена!%n", title);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Поток прерван! " + e);
        }
    }
}
