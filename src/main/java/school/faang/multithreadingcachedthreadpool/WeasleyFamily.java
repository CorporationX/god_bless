package school.faang.multithreadingcachedthreadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {
    private final ExecutorService executorService = java.util.concurrent.Executors.newCachedThreadPool();
    private final List<Chore> chores = new ArrayList<>();

    public void addChore(Chore chore) {
        chores.add(chore);
    }

    public void doChores() {
        for (Chore chore : chores) {
            executorService.execute(chore);
        }
        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(1, TimeUnit.MINUTES)) {
                System.out.println("Not all tasks are completed.");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            executorService.shutdownNow();
        }
    }
}
