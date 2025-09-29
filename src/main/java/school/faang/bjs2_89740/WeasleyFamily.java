package school.faang.bjs2_89740;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WeasleyFamily {
    private static final int AWAIT_TERMINATION = 1;
    private static final List<String> chores = List.of("помыть посуду", "подмести пол", "приготовить ужин");
    private final ExecutorService executor = Executors.newCachedThreadPool();

    public void choresJob() {
        for (String task : chores) {
            Chore chore = new Chore(task);
            executor.execute(chore);
        }

        executor.shutdown();
        try {
            if (!executor.awaitTermination(AWAIT_TERMINATION, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}
