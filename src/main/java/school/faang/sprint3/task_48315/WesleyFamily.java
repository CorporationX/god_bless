package school.faang.sprint3.task_48315;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WesleyFamily {
    private final List<Chore> chores = new ArrayList<>();
    private final ExecutorService threadPool = Executors.newCachedThreadPool();

    public void addChore(Chore chore) {
        chores.add(chore);
    }

    public void doChores() {
        for (Chore chore : chores) {
            threadPool.submit(chore);
        }
        threadPool.shutdown();
        try {
            threadPool.awaitTermination(5, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            threadPool.shutdownNow();
        }
    }
}
