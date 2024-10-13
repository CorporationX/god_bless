package school.faang.extremelypor.maincode;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {
    private static String[] tasks = {"задача помыть посуду", "задача подмести пол",
            "задача приготовить ужин"};
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        for (String task : tasks) {
            Chore chore = new Chore(task);
            executor.submit(chore);
        }

        executor.shutdown();

        try {
            if (!executor.awaitTermination(5, TimeUnit.MINUTES)) {
                System.out.println("Не все задачи завершены в указанный период времени");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}
