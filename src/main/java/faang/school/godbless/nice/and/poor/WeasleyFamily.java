package faang.school.godbless.nice.and.poor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {
    private static final int TIME_FOR_ALL_CHORES_IN_SECONDS = 5;

    public static void main(String[] args) {
        String[] chores = {"Wash the dishes", "Clean the house's garden", "Wash the floors", "Declutter the table",
                "Cook a dinner", "Make a tea", "Wipe of the dust", "Wash clothes"};

        ExecutorService executorService = Executors.newCachedThreadPool();

        try {
            for (String chore : chores) {
                executorService.submit(new Chore(chore));
            }
        } finally {
            executorService.shutdown();
            try {
                if (!executorService.awaitTermination(TIME_FOR_ALL_CHORES_IN_SECONDS, TimeUnit.SECONDS)) {
                    executorService.shutdownNow();
                }
            } catch (InterruptedException e) {
                executorService.shutdownNow();
                Thread.currentThread().interrupt();
            }
        }
    }
}
