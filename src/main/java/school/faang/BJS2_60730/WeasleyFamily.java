package school.faang.BJS2_60730;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {
    private final String[] tasks = {"помыть посуду", "подмести пол", "приготовить ужин"};
    private final ExecutorService executor = Executors.newCachedThreadPool();

    public void doTask() {
        for (String task : tasks) {
            Chore chore = new Chore(task);
            executor.execute(chore);
        }
        executor.shutdown();
        try {
            boolean tasksCompleted = executor.awaitTermination(5, TimeUnit.MINUTES);
            if (tasksCompleted) {
                System.out.println("Все задачи выполнены");
            } else {
                System.out.println("Не все задачи были выполнены в течение отведенного времени");
            }
        } catch (InterruptedException e) {
            System.err.printf("InterruptedException: %s\n", e.getMessage());
            Thread.currentThread().interrupt();
        }
    }
}
