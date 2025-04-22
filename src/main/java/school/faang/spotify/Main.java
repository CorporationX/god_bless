package school.faang.spotify;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Player player = new Player();

        List<Runnable> users = List.of(
                player::play,
                player::pause,
                player::skip,
                player::previous,
                player::skip,
                player::pause,
                player::play,
                player::play,
                player::play,
                player::pause,
                player::previous,
                player::play,
                player::skip,
                player::play
        );

        ExecutorService executor = Executors.newFixedThreadPool(3);
        users.forEach(executor::submit);
        executor.shutdown();
        if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
            executor.shutdownNow();
        }
    }
}
