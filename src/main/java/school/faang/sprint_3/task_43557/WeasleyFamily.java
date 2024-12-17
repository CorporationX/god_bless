package school.faang.sprint_3.task_43557;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {
    private static final int TIMEOUT = 2;

    private final List<String> chores = new ArrayList<>();

    public void addChore(String chore) {
        chores.add(chore);
    }

    public void performChores() {
        ExecutorService executor = Executors.newCachedThreadPool();
        for (String task : chores) {
            Chore chore = new Chore(task);
            executor.execute(chore);
        }

        executor.shutdown();

        try {
            if (!executor.awaitTermination(TIMEOUT, TimeUnit.MINUTES)) {
                System.out.println("Не все задачи завершены в указанный период времени.");
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}
