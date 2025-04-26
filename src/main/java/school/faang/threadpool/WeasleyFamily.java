package school.faang.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {
    private static final int AWAITING_SECONDS = 10;

    private static final String[] CHORES = {
            "помыть посуду",
            "подмести пол",
            "приготовить ужин",
            "постирать бельё",
            "покормить сову",
            "почистить камин",
            "прополоть огород"
    };

    public static void softShutdown(ExecutorService executor) {
        executor.shutdown();

        try {
            // ждём завершения всех задач
            if (!executor.awaitTermination(AWAITING_SECONDS, TimeUnit.SECONDS)) {
                System.out.println("Execution is not terminated in time. Forced shutdown!");
                executor.shutdownNow();
            } else {
                System.out.println("Execution terminated successfully!");
            }
        } catch (InterruptedException e) {
            System.out.println("Main thread was interrupted. Forcing shutdown...");
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        for (String choreName : CHORES) {
            Chore chore = new Chore(choreName);
            executor.submit(chore);
        }

        softShutdown(executor);
    }
}
