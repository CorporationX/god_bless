package school.faang.cashedpoolthread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService threadsForTasks = Executors.newCachedThreadPool();

        for (int i = 0; i < WeasleyFamily.getChores().length; i++) {
            Chore chore = new Chore(WeasleyFamily.getChores()[i]);
            threadsForTasks.execute(chore);

        }
        threadsForTasks.shutdown();
        threadsForTasks.awaitTermination(5, TimeUnit.SECONDS);
        System.out.println("All tasks hae been done");
        System.out.println("The thread " + Thread.currentThread().getName() + " ends its work");
    }
}
