package school.faang.they.were.very.nice.but.extremely.poor;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {
    private static final int TIME_FOR_WAITING = 1;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        List<Chore> chores = List.of(new Chore("помыть посуду"),
                new Chore("подмести пол"),
                new Chore("приготовить ужин")
        );

        chores.forEach(executor::execute);

        executor.shutdown();
        try {
            if (!executor.awaitTermination(TIME_FOR_WAITING, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}
