package school.faang.bjs2_89639;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@AllArgsConstructor
public class WeasleyFamily {
    private static final int AWAIT_TERMINATE_MIN = 1;
    private List<String> chores;

    public void doTask() {
        ExecutorService executor = Executors.newCachedThreadPool();

        try {
            for (String chore : chores) {
                executor.submit(new Chore(chore));
            }
        } finally {
            executor.shutdown();

            try {
                if (!executor.awaitTermination(AWAIT_TERMINATE_MIN, TimeUnit.MINUTES)) {
                    executor.shutdownNow();
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        }
    }
}
