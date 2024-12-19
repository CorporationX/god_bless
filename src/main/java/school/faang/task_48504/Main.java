package school.faang.task_48504;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        WeasleyFamily weasleyFamily = new WeasleyFamily();
        ExecutorService executor = Executors.newCachedThreadPool();

        executor.execute(() -> {
            for (int i = 0; i < weasleyFamily.getChores().size(); i++) {
                new Chore(weasleyFamily.getChores().get(i).toString()).run();
            }
        });

        executor.shutdown();

        try {
            if (!executor.awaitTermination(3, TimeUnit.MINUTES)) {
                System.out.println("Задачи не завершились за необходимое время!!!");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}
