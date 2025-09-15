package school.faang.bjs2_89592;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Weasley {
    String[] listTask = {"Wash the floor", "Cook dinner", "Vacuum", "Wipe off the dust"};
    ExecutorService executor = Executors.newCachedThreadPool();

    public void weasleyWork() {
        for (int i = 0; i < listTask.length; i++) {
            Chore chore = new Chore(listTask[i]);
            executor.execute(chore);
        }
        executor.shutdown();
        try {
            if (executor.awaitTermination(10, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
        System.out.println("thread closed");
    }
}
