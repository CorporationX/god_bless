package school.faang.bjs2_72300;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Army {
    private static final int THREAD_POOL_COUNT = 3;
    private static final int TIMEOUT = 10;
    private final List<Squad> listSquads = new ArrayList<>();

    public void addSquad(Squad squad) {
        listSquads.add(squad);
    }

    public int calculateTotalPower() {
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_COUNT);
        List<Integer> result = new ArrayList<>();
        for (Squad squad : listSquads) {
            executor.submit(() -> result.add(squad.calculateSquadPower()));
            log.info("Start new thread");
        }

        gracefullyShutdown(executor);

        return result.stream().reduce(0, Integer::sum);
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
