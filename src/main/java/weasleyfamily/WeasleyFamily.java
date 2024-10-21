package weasleyfamily;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {
    public static void main(String[] args) {
        String[] chores = {"помыть посуду", "подмести пол", "приготовить ужин"};
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

        for (String chore : chores) {
            cachedThreadPool.execute(new Chore(chore));
        }

        cachedThreadPool.shutdown();
        try {
            if (!cachedThreadPool.awaitTermination(5, TimeUnit.MINUTES)) {
                cachedThreadPool.shutdownNow();
            }
        } catch (InterruptedException e) {
            cachedThreadPool.shutdownNow();
        }
    }
}
