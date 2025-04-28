package school.faang.bjs273466;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Main {
    private static final int WAIT_TIME = 1;
    private static final int MAX_PLAYERS = 5;

    public static void main(String[] args) {
        Boss boss = new Boss(MAX_PLAYERS);
        List<Player> players = new ArrayList<>();
        IntStream.range(1, 15).forEach(i -> players.add(new Player(String.format("Player %d", i))));
        ExecutorService executor = Executors.newCachedThreadPool();
        players.forEach(player ->
                executor.submit(() -> player.doBattle(boss))
        );
        executor.shutdown();
        try {
            if (!executor.awaitTermination(WAIT_TIME, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}

