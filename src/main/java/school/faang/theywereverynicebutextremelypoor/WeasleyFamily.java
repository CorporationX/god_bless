package school.faang.theywereverynicebutextremelypoor;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
@RequiredArgsConstructor
public class WeasleyFamily {
    @NonNull
    private final List<Chore> chores;
    private final ExecutorService executor = Executors.newCachedThreadPool();

    public void threadSet() {
        for (Chore chore : chores) {
            executor.submit(chore);
        }

        executor.shutdown();
        try {
            if (!executor.awaitTermination(15, TimeUnit.SECONDS)) {
                System.out.println("Tasks didn't finish within 5 seconds, forcing shutdown...");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error("Thread {} was interrupted during forced shutdown!", Thread.currentThread().getName(), e);
        }
    }
}
