package school.faang.theywereverynice;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class WeasleyFamily {
    private static final List<Chore> CHORES = List.of(
            new Chore("task 1"), new Chore("task 2"), new Chore("task 3"),
            new Chore("task 4"), new Chore("task 5"), new Chore("task 6"),
            new Chore("task 7"), new Chore("task 8"), new Chore("task 9")
    );

    public static void main(String[] args) {
        try {
            ExecutorService executorService = Executors.newCachedThreadPool();
            if (!CHORES.isEmpty()) {
                CHORES.forEach(executorService::submit);
            } else {
                throw new IllegalArgumentException("No chores available");
            }
            while (!executorService.isTerminated()) {
                executorService.shutdown();
            }
            log.info("All done");
        } catch (Exception exception) {
            log.error(exception.getMessage(), exception);
        }
    }
}
