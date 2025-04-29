package school.faang.bjs2_73621;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    public static final int MAX_PLAYERS = 2;
    public static final int THREADS_COUNT = 3;
    public static final int AWAITING_TIME = 2;

    public static void main(String[] args) {
        Boss boss = new Boss(MAX_PLAYERS);
        Player annie = new Player("Annie");
        Player alice = new Player("Alice");
        Player mert = new Player("Mert");
        ExecutorService executorService = Executors.newFixedThreadPool(THREADS_COUNT);
        executorService.execute(() -> annie.doBattle(boss));
        executorService.execute(() -> alice.doBattle(boss));
        executorService.execute(() -> mert.doBattle(boss));
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(AWAITING_TIME, TimeUnit.MINUTES)) {
                log.info("Timeout: battles were not completed within the allotted time");
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
            throw new IllegalStateException("The thread was interrupted while waiting for completion battles", e);
        }
    }
}
