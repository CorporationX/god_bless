package school.faang.sprint3.task_60800;

import lombok.AllArgsConstructor;

import java.util.concurrent.atomic.AtomicInteger;

@AllArgsConstructor
public class Chore implements Runnable {
    public static final AtomicInteger COUNT = new AtomicInteger(0);
    private String chore;

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.printf("%d) Задача %s выполнена в потоке %s\n", COUNT.incrementAndGet(), chore, threadName);
    }
}
