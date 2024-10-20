package faang.school.godbless.mt.tasks;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class WeasleyFamily {
    private static final int CHORES_TIMEOUT_IN_SECONDS = 15;
    private final List<Chore> chores;

    public WeasleyFamily(List<Chore> chores) {
        this.chores = new ArrayList<>(chores);
    }

    public void startChores() {
        ExecutorService executor = Executors.newCachedThreadPool();
        chores.forEach(executor::execute);
        executor.shutdown();

        try {
            if (!executor.awaitTermination(CHORES_TIMEOUT_IN_SECONDS, TimeUnit.SECONDS)) {
                log.info("Not all chores is finished");
                executor.shutdownNow();
            }

        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}
