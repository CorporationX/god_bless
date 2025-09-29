package school.faang.bjs2_89870;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {
    private final Chore[] chores = {
            new Chore("помыть посуду"),
            new Chore("подмести пол"),
            new Chore("приготовить ужин")
    };

    public void doChores() {
        ExecutorService executors = Executors.newCachedThreadPool();

        for (Chore chore : chores) {
            executors.submit(chore);
        }

        executors.shutdown();

        try {
            if (!executors.awaitTermination(1, TimeUnit.MINUTES)) {
                System.err.println("Не все задачи завершились вовремя");
                executors.shutdownNow();
            }
        } catch (InterruptedException e) {
            executors.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}