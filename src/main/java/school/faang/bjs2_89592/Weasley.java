package school.faang.bjs2_89592;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Weasley {
    private static final int TIME_SHUTDOWN = 10;
    private static final String[] listTask = {"Wash the floor", "Cook dinner", "Vacuum", "Wipe off the dust"};
    private static ExecutorService executor = Executors.newCachedThreadPool();

    public void weasleyWork() {
        for (int i = 0; i < listTask.length; i++) {
            Chore chore = new Chore(listTask[i]);
            executor.execute(chore);
        }
        executor.shutdown();
        try {
            if (executor.awaitTermination(TIME_SHUTDOWN, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
        System.out.println("thread closed");
    }
}
