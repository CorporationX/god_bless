package faang.school.godbless.Supercow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
                    player.startBattle(boss, player);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        executor.shutdown();
    }
}
