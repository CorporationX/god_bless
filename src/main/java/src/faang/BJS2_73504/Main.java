package src.faang.BJS2_73504;

import src.faang.BJS2_73504.model.Boss;
import src.faang.BJS2_73504.model.Player;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int MAX_PLAYERS_FOR_BOSS = 2;
    private static final int PLAYERS_COUNT = 10;

    public static void main(String[] args) {
        final Boss boss = new Boss(MAX_PLAYERS_FOR_BOSS);
        final ExecutorService executor = Executors.newFixedThreadPool(PLAYERS_COUNT);

        for (int i = 0; i < PLAYERS_COUNT; i++) {
            int finalI = i;
            executor.execute(() -> {
                final Player player = new Player("Player" + finalI);
                player.doBattle(boss);
            });
        }

        executor.shutdown();
        awaitTermination(executor);
    }

    private static void awaitTermination(ExecutorService executor) {
        try {
            if (executor.awaitTermination(TimeUnit.SECONDS.toSeconds(20), TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }
}
