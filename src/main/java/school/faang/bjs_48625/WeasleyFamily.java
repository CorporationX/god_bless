package school.faang.bjs_48625;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class WeasleyFamily {
    private static final int TIMEOUT_AWAIT_SECONDS = 10;

    public void familyWork() {
        List<Chore> choreList = List.of(
                new Chore("Clear the table"),
                new Chore("Collect the dishes"),
                new Chore("Wash clothes"),
                new Chore("Clean windows"),
                new Chore("Feed pets")
        );

        ExecutorService executorService = Executors.newCachedThreadPool();
        choreList.forEach(executorService::submit);
        executorService.shutdown();

        try {
            executorService.awaitTermination(TIMEOUT_AWAIT_SECONDS, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            log.error("Timeout occurred while waiting for family work", e);
        }
    }
}
