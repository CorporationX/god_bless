package school.faang.sprint3.task_48315;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

@RequiredArgsConstructor
public class Chore implements Runnable {
    private final String description;

    @SneakyThrows
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " starts doing " + description);
        Thread.sleep(5000);
        System.out.println(Thread.currentThread().getName() + " ended doing " + description);
    }
}
