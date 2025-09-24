package school.faang.they_were_very_bjs2_89703;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {
    public static void main(String[] args) {
        List<String> chores = Arrays.asList(
                "помыть посуду",
                "подмести пол",
                "приготовить ужин"
        );

        ExecutorService executor = Executors.newCachedThreadPool();

        for (String task : chores) {
            executor.submit(new Chore(task));
        }
        executor.shutdown();
        try {
            if (!executor.awaitTermination(10, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
        System.out.println("Все сделано");
    }
}
