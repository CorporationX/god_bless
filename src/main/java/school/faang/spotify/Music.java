package school.faang.spotify;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Stream;

public class Music {
    private static final int FIXED_TREADS = 3;

    public static void main(String[] args) {
        Object lock = new Object();
        AtomicBoolean isPlaying = new AtomicBoolean();
        ExecutorService executorService = Executors.newFixedThreadPool(FIXED_TREADS);
        List<Player> players = Arrays.asList(
                new Player(" a", lock, isPlaying),
                new Player(" s", lock, isPlaying),
                new Player(" d", lock, isPlaying)
        );

        players.stream()
                .flatMap(player -> Stream.of(
                        (Runnable) player::play,
                        (Runnable) player::pause,
                        (Runnable) player::skip,
                        (Runnable) player::previous
                ))
                .forEach(executorService::submit);

        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(10, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }
        System.out.println("Все действия завершили");
    }
}
