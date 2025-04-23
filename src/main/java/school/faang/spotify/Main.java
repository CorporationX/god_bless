package school.faang.spotify;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Player player = new Player(new Music());
        List<Runnable> userTask = List.of(
                player::play,
                player::play,
                player::play,
                player::pause,
                player::skip,
                player::play,
                player::previous,
                player::pause,
                player::previous
        );

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        userTask.forEach(executorService::submit);

        executorService.shutdown();
        if (!executorService.awaitTermination(3, TimeUnit.SECONDS)) {
            executorService.shutdownNow();
        }
    }
}