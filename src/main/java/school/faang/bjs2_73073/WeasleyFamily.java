package school.faang.bjs2_73073;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class WeasleyFamily {
    public static final int AWAIT_TIMEOUT_MINUTES = 1;

    private static List<Chore> chores = Arrays.asList(Chore.WASH_DISHES, Chore.SWEEP_FLOOR, Chore.COOK_DINNER);

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        chores.forEach(chore -> executorService.execute(new ChoreTask(chore)));
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(AWAIT_TIMEOUT_MINUTES, TimeUnit.MINUTES)) {
                log.warn("Timeout: chores tasks were not completed within the allotted time");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
            throw new IllegalStateException("The thread was interrupted while waiting for completion chores tasks", e);
        }
    }
}
