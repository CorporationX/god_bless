package school.faang.bjs2_81646;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Task implements Runnable {
    private static final int SLEEP_TIME = 5000;
    private final String name;
    private final String task;

    public void run() {
        try {
            System.out.printf("%s взял задачу %s%n", name, task);
            Thread.sleep(SLEEP_TIME);
            System.out.printf("%s выполнил задачу %s%n", name, task);
        } catch (InterruptedException e) {
            System.out.printf("%s прервал задачу %s%n", name, task);
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}
