package school.faang.bjs2_89732;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {
    public static void main(String[] args) {
        List<Chore> chores = List.of(new Chore("помыть посуду"), new Chore("подмести пол"), new Chore("приготовить ужин"));
        ExecutorService executor = Executors.newCachedThreadPool();
        for (Chore chore : chores) {
            executor.execute(chore);
        }
        executor.shutdown();
        try {
            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}