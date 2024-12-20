package school.faang.sprint_3.task_49226;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Player player = new Player();
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        executorService.submit(player::play);
        executorService.submit(player::pause);
        executorService.submit(player::skip);
        executorService.submit(player::play);
        executorService.submit(player::play);
        executorService.submit(player::play);
        executorService.submit(player::previous);
        executorService.submit(player::pause);

        executorService.shutdown();
        try {
            executorService.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            log.error("Executor service await termination error", e);
        }

        log.info(String.valueOf(player.isPlaying()));
    }
}
