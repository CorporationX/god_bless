package school.faang.parallelism.nice_but_poor;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {

    private static final int TERMINATION_MINUTES = 1;

    public static void main(String[] args) {

        ExecutorService threadPool = Executors.newCachedThreadPool();
        WeasleyFamily.CHORE_LIST.forEach(chore -> threadPool.execute(new Chore(chore)));
        threadPool.shutdown();

        try {
            if (!threadPool.awaitTermination(TERMINATION_MINUTES, TimeUnit.MINUTES)) {
                log.info("Chores were not finished in {} minute, forcing s shutdown", TERMINATION_MINUTES);
                threadPool.shutdownNow();
            }
        } catch (InterruptedException e) {
            threadPool.shutdownNow();
        }

    }
}
