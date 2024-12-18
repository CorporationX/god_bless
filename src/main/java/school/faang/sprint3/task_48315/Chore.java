package school.faang.sprint3.task_48315;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

@RequiredArgsConstructor
public class Chore implements Runnable {
    private static final int COMPLETING_TIME = 5000;
    private final String description;

    @SneakyThrows
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " starts doing " + description);
        Thread.sleep(COMPLETING_TIME);
        System.out.println(Thread.currentThread().getName() + " ended doing " + description);
    }
}
