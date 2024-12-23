package school.faang.bjs_49249;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Music {
    private static final int THREAD_POOL_SIZE = 5;
    private static final int TIMEOUT_SECONDS = 20;

    public void startMusic() {
        List<Runnable> tasks = new ArrayList<>();
        Player player = new Player();
        tasks.add(player::play);
        tasks.add(player::pause);
        tasks.add(player::play);
        tasks.add(player::skip);
        tasks.add(player::skip);
        tasks.add(player::pause);
        tasks.add(player::previous);

        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        tasks.forEach(executorService::execute);

        try {
            executorService.awaitTermination(TIMEOUT_SECONDS, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            log.error("Thread was interrupted", e);
        }

        executorService.shutdown();
    }
}
