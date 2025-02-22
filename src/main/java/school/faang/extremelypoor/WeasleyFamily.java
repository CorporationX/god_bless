package school.faang.extremelypoor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {
    private static final String[] CHORES = {"помыть посуду", "подмести пол", "приготовить ужин"};

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        for (String chore : CHORES) {
            Chore choreTask = new Chore(chore);
            executor.submit(choreTask);
        }
        executor.shutdown();

        try {
            if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}
