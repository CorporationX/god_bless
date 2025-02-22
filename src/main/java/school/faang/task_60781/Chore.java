package school.faang.task_60781;

import lombok.AllArgsConstructor;
import lombok.NonNull;

@AllArgsConstructor
public class Chore implements Runnable {
    private static final int LEAD_TIME = 5000;

    @NonNull
    private final String title;

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.printf("%s: выполнение задачи \"%s\"%n", threadName, title);
        try {
            Thread.sleep(LEAD_TIME);
            System.out.printf("%s: задача \"%s\" выполнена%n", threadName, title);
        } catch (InterruptedException e) {
            System.out.printf("%s: задача \"%s\" прервана%n", threadName, title);
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}
