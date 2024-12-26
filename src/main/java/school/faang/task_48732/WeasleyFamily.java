package school.faang.task_48732;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {
    private final String[] chores;
    ExecutorService executor = Executors.newCachedThreadPool();

    public WeasleyFamily(String[] chores) {
        this.chores = chores;
    }

    public void executeChores() {
        for (String task : chores) {
            Chore chore = new Chore(task);
            executor.execute(chore);
        }

        executor.shutdown();

        try {
            if (!executor.awaitTermination(5, TimeUnit.MINUTES)) {
                System.out.println("Не все задачи завершены в указанный период времени.");
            }
        } catch (InterruptedException e) {
            System.out.println("Экстренная остановка пула");
            executor.shutdownNow();
        }
    }
}

