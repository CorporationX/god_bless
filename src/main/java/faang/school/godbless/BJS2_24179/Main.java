package faang.school.godbless.BJS2_24179;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        List<Player> players = Arrays.asList(new Player("Player1"),
                new Player("Player2"),
                new Player("Player3"),
                new Player("Player4"),
                new Player("Player5")
        );
        Boss boss = new Boss(3);
        ExecutorService executor = Executors.newFixedThreadPool(players.size());
        players.forEach(player -> executor.execute(() -> player.startBattle(boss)));

        try {
            executor.shutdown();
            if (executor.awaitTermination(60, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
