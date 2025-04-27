package school.faang.bjs272991;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {

    public String[] chores = {"Clean a house", "Wash a dish", "Make a dinner"};
    ExecutorService executor = Executors.newCachedThreadPool();


    public final void assignTask(String[] chores) {
        for (String string : chores) {
            Chore chore = new Chore(string);
            executor.execute(chore);
        }
        executor.shutdown();
        try {
            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}
