package school.faang.bjs2_73377;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Music {
    private static final int THREAD_POOL_COUNT = 3;
    private static final int TIMEOUT = 10;

    public static void main(String[] args) {
        Player player = new Player();
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_COUNT);
        List<Thread> threadList = List.of(
                new Thread(player::play),
                new Thread(player::pause),
                new Thread(player::skip),
                new Thread(player::pause),
                new Thread(player::play),
                new Thread(player::previous),
                new Thread(player::play),
                new Thread(player::pause)
        );

        for (Thread thread : threadList) {
            executor.submit(thread);
        }

        gracefullyShutdown(executor);
    }

    private static void gracefullyShutdown(ExecutorService executor) {
        executor.shutdown();

        try {
            if (!executor.awaitTermination(TIMEOUT, TimeUnit.SECONDS)) {
                log.info("Tasks not completed in {} }seconds, forcibly stopping...", TIMEOUT);
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}