package school.faang.sprint3.task_60800;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Chore implements Runnable {
    public static int count = 1;
    private String chore;

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.printf("%d) Задача %s выполнена в потоке %s\n", count++, chore, threadName);
    }
}
