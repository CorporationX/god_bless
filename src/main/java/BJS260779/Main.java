package BJS260779;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();
        WeasleyFamily weasleyFamily = new WeasleyFamily();

        for (int i = 0; i < weasleyFamily.getChores().size(); i++) {
            Chore chore = new Chore(weasleyFamily.getChores().get(i).getChore());
            executor.execute(chore);
        }
        executor.shutdown();
        try {
            if (!executor.awaitTermination(3, TimeUnit.MINUTES)) {
                System.out.println("Задачи не выполнены");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}
