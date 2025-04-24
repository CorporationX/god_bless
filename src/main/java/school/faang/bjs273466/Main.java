package school.faang.bjs273466;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int WAIT_TIME = 1;

    public static void main(String[] args) {
        Boss boss = new Boss(5);
        List<Player> players = new ArrayList<>();
        for (int i = 1; i < 15; i++) {
            players.add(new Player("Player " + i));
        }
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

