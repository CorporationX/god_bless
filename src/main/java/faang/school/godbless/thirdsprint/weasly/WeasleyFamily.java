package faang.school.godbless.thirdsprint.weasly;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {
    public static void main(String[] args) {
        String[] tasks = {
                "Подмести пол",
                "Помыть посуду",
                "Прополоть огород",
                "Приготовить обед",
                "Починить дверь",
                "Постирать белье"
        };

        ExecutorService executor = Executors.newCachedThreadPool();
        Arrays.stream(tasks).forEach(task -> executor.execute(new Chore(task)));
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
