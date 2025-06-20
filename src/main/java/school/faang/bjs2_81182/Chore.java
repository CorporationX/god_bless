package school.faang.bjs2_81182;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Chore implements Runnable {
    private final String chore;
    private static final int SLEEP_TIME = 5000;

    public void run() {
        try {
            System.out.printf("%s взял на себя задачу: %s%n", Thread.currentThread().getName(), chore);
            Thread.sleep(SLEEP_TIME);
            System.out.printf("задача %s выполнена%n", chore);
        } catch (InterruptedException e) {
            System.out.printf("задача %s прервалась%n", chore);
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}