package school.faang.task_48326;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

@RequiredArgsConstructor
public class Chore implements Runnable {
    private final String chore;

    @SneakyThrows
    @Override
    public void run() {
        System.out.printf("Выполняется задача = %s, в потоке = %s%n", chore, Thread.currentThread().getName());
        Thread.sleep(1000);
        System.out.printf("Выполнилась задача = %s, в потоке = %s%n", chore, Thread.currentThread().getName());
    }
}
