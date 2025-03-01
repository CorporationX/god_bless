package school.faang.task_61083;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {
    private static final int TIMEOUT = 1;
    private static final Chore[] chores = {
            new Chore("Помыть посуду"),
            new Chore("Сделать домашние задание"),
            new Chore("Приготовить ужин"),
    };

    ExecutorService executorService = Executors.newCachedThreadPool();

    public void executeChores() {
        for (Chore task : chores) {
            executorService.submit(task);
        }
        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(TIMEOUT, TimeUnit.MINUTES)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            throw new RuntimeException("Поток был прерван! " + e);
        }
    }
}
