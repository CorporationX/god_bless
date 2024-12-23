package school.faang.task_49189;

import lombok.extern.slf4j.Slf4j;

import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final long DELAY = 5;
    private static final int NUMBER_THREADS = 10;

    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(NUMBER_THREADS);
        List<MusicTrack> musicTrackList = List.of(
                new MusicTrack("Летела жизнь", Duration.ofSeconds(150)),
                new MusicTrack("Сафари", Duration.ofSeconds(177)),
                new MusicTrack("До / После", Duration.ofSeconds(160))
        );
        Player player = new Player(musicTrackList);
        List<Runnable> playerFunctions = List.of(
                (player::play),
                (player::pause),
                (player::skip),
                (player::previous)
        );
        Random random = new Random();
        long executionTime = NUMBER_THREADS * DELAY;

        executorService.execute(playerFunctions.get(0));
        for (int i = 0; i < NUMBER_THREADS * DELAY; i += DELAY) {
            var index = random.nextInt(playerFunctions.size());
            executorService.schedule(playerFunctions.get(index),
                    DELAY + i, TimeUnit.SECONDS);
        }

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(executionTime, TimeUnit.SECONDS)) {
                log.info("Player has shutdown");
                executorService.shutdownNow();
            }
        } catch (InterruptedException ex) {
            log.error("Error occurred: {}", ex.getMessage());
            executorService.shutdownNow();
        }

    }
}
