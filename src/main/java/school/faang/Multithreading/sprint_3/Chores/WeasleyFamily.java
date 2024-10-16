package school.faang.Multithreading.sprint_3.Chores;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {
    private final String[] chores = new String[]{"помыть посуду", "подмести пол", "приготовить ужин"};

    public void doChore() throws InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();

        for (String task : chores) {
            Chore chore = new Chore(task);
            executor.submit(chore);
        }

        executor.shutdown();

        if (executor.awaitTermination(60, TimeUnit.SECONDS)) {
            System.out.println("Все задачи выполнены");
        } else {
            System.out.println("Не все задачи были выполнены");
            executor.shutdownNow();
        }
    }
}
