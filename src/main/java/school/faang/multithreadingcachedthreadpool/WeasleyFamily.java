package school.faang.multithreadingcachedthreadpool;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {
    ExecutorService executorService = java.util.concurrent.Executors.newCachedThreadPool();
    List<Chore> chores = new ArrayList<>();

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
            System.out.println(Arrays.toString(e.getStackTrace()));
            executorService.shutdownNow();
        }
    }
}
