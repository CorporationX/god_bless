package school.faang.task_48326;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

@RequiredArgsConstructor
public class Chore implements Runnable {
    public static final int ONE_SECOND = 1000;
    private final String chore;

    @SneakyThrows
    @Override
    public void run() {
        System.out.printf("Выполняется задача = %s, в потоке = %s%n", chore, Thread.currentThread().getName());
        Thread.sleep(ONE_SECOND);
        System.out.printf("Выполнилась задача = %s, в потоке = %s%n", chore, Thread.currentThread().getName());
    }
}
