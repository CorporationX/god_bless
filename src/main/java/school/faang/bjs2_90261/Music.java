package school.faang.bjs2_90261;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Music {
    private static final int COUNT_THREAD = 4;
    private static final int AWAIT_TERMINATION_MIN = 1;

    public static void main(String[] args) {
        Player player = new Player();

        ExecutorService executor = Executors.newFixedThreadPool(COUNT_THREAD);

        List<Runnable> tasks = List.of(
                () -> user1Actions(player),
                () -> user2Actions(player),
                () -> user3Actions(player),
                () -> user4Actions(player)
        );

        try {
            for (Runnable task : tasks) {
                executor.submit(task);
            }
        } finally {
            executor.shutdown();

            try {
                if (!executor.awaitTermination(AWAIT_TERMINATION_MIN, TimeUnit.MINUTES)) {
                    executor.shutdownNow();
                }
            } catch (InterruptedException e) {
                executor.shutdownNow();
                Thread.currentThread().interrupt();
            }
        }
    }

    private static void user1Actions(Player player) {
        player.play();
        player.pause();
    }

    private static void user2Actions(Player player) {
        player.skip();
        player.play();
    }

    private static void user3Actions(Player player) {
        player.previous();
        player.play();
    }

    private static void user4Actions(Player player) {
        player.pause();
        player.skip();
    }
}
