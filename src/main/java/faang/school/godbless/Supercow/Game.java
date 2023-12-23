package faang.school.godbless.Supercow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Game {
    public static void main(String[] args) {
        Boss boss = new Boss(3);
        List<Player> players = new ArrayList<>(Arrays.asList(
                new Player("player1"),
                new Player("player2"),
                new Player("player3"),
                new Player("player4"),
                new Player("player5")));

        ExecutorService executor = Executors.newFixedThreadPool(3);
        for (Player player : players) {
            executor.submit(() -> {
                try {
                    player.startBattle(boss);
                    Thread.sleep(3000);
                    boss.endBattle(player);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        executor.shutdown();
        try {
            // Ждем завершения всех потоков
            executor.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
