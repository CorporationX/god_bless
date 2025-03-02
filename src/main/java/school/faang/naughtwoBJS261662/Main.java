package school.faang.naughtwoBJS261662;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int WAIT_TIME_MINUTES = 2;

    public static void main(String[] args) {
        List<Player> players = addPlayers();

        Boss kikimores = new Boss("Kikimores", 4);
        Boss golems = new Boss("Golems", 2);

        ExecutorService executor = Executors.newFixedThreadPool(3);
        willFightTheBoss(executor, players, kikimores);
        willFightTheBoss(executor, players, golems);

        executor.shutdown();
        log.info("All fight are finished.");

        try {
            if (!executor.awaitTermination(WAIT_TIME_MINUTES, TimeUnit.MINUTES)) {
                executor.shutdown();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }
    }

    private static List<Player> addPlayers() {
        return new ArrayList<>(Arrays.asList(
                new Player("Player 1"),
                new Player("Player 2"),
                new Player("Player 3"),
                new Player("Player 4")
        ));
    }

    private static void willFightTheBoss(ExecutorService executor, List<Player> players, Boss boss) {
        for (Player player : players) {
            executor.submit(() -> {
                player.doBattle(boss);
                log.info("{} finished the fight with {}", player.getName(), boss.getName());
            });
        }
    }
}
