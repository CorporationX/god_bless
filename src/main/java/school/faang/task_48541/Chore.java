package school.faang.task_48541;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Chore implements Runnable {
    private static final int SLEEP_TIME_MS = 3000;
    private static final String TASK_STARTED_MSG = "%s выполняет: %s %n";
    private static final String TASK_COMPLETED_MSG = "%s выполнился %n";
    private static final String EXCEPTION_OCCURRED = "Произошло исключение с: %s %n";

    private String chore;

    public Chore(String chore) {
        this.chore = chore;
    }

    @Override
    public void run() {
        try {
            String name = Thread.currentThread().getName();
            System.out.printf(TASK_STARTED_MSG, name, chore);
            Thread.sleep(SLEEP_TIME_MS);
            System.out.printf(TASK_COMPLETED_MSG, chore);
        } catch (InterruptedException e) {
            System.out.printf(EXCEPTION_OCCURRED, chore);
        }
    }
}
