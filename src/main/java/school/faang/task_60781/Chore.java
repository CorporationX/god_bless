package school.faang.task_60781;

import lombok.AllArgsConstructor;
import lombok.NonNull;

@AllArgsConstructor
public class Chore implements Runnable {
    private static final int LEAD_TIME = 5000;
    private static final String TASK_COMPLETION = "%s: выполнение задачи \"%s\"%n";
    private static final String TASK_COMPLETED = "%s: задача \"%s\" выполнена%n";
    private static final String TASK_INTERRUPTED = "%s: задача \"%s\" прервана%n";

    @NonNull
    private final String title;

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.printf(TASK_COMPLETION, threadName, title);
        try {
            Thread.sleep(LEAD_TIME);
            System.out.printf(TASK_COMPLETED, threadName, title);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.printf(TASK_INTERRUPTED, threadName, title);
            throw new RuntimeException(e);
        }
    }
}
