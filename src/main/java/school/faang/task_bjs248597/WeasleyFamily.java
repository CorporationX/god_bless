package school.faang.task_bjs248597;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {
    private static final String[] chores = {"помыть посуду", "выдворить гномов", "протереть волшебные часы",
            "подмести полы", "еще раз выдворить гномов"};
    static ExecutorService tasks = Executors.newCachedThreadPool();

    public static void main(String[] args) {
        for (String choreName : chores) {
            Chore familyChore = new Chore(choreName);
            tasks.submit(familyChore);
        }
        tasks.shutdown();
        try {
            if (!tasks.awaitTermination(3, TimeUnit.SECONDS)) {
                tasks.shutdownNow();
            }
        } catch (InterruptedException e) {
            tasks.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
