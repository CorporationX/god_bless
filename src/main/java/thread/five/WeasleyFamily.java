package thread.five;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {

    public static void main(String[] args) {

        int choreCount = 10;
        Chore[] chore = new Chore[choreCount];
        ExecutorService cacheExecutor = Executors.newCachedThreadPool();

        for (int i = 0; i < chore.length; i++) {
            chore[i] = new Chore("Task" + (i + 1));
            cacheExecutor.execute(chore[i]);
        }

        cacheExecutor.shutdown();

        try {
            if (!cacheExecutor.awaitTermination(5, TimeUnit.MINUTES)) {
                cacheExecutor.shutdownNow();
            }
        } catch (InterruptedException e) {
            cacheExecutor.shutdownNow();
        }
        System.out.println("Все задания выполнены.");

    }
}
