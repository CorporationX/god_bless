package school.faang.cachechores;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        WeasleyFamily tasks = new WeasleyFamily();
        for (int i = 0; i < 10000; i++) {
            tasks.addChore(new Chore("task" + i));
        }

        ExecutorService executor = Executors.newCachedThreadPool();
        for (Chore chore : tasks.getChores()) {
            executor.submit(chore);
        }
        executor.shutdown();

        try {
            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
        System.out.println("After running all threads");
    }
}
