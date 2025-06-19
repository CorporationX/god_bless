package school.faang.bjs2_81182;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {
    public static void main(String[] args) throws InterruptedException {
        String[] chores = {"готовить", "уборка", "вода мыть посуда", "стиралка"};

        ExecutorService executor = Executors.newCachedThreadPool();

        for (String chore : chores) {
            executor.submit(new Chore(chore));
        }
        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS);
    }
}
