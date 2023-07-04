package faang.school.godbless.sprint4.supercow;

import faang.school.godbless.sprint4.supercow.classes.Boss;
import faang.school.godbless.sprint4.supercow.classes.Player;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final int NUM_THREAD = 5;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREAD);

        List<Player> players = List.of(
                new Player("Player 1"),
                new Player("Player 2"),
                new Player("Player 3"),
                new Player("Player 4"),
                new Player("Player 5")
        );

        Boss boss = new Boss(2);

        for (Player player : players) {
            executor.execute(() -> player.startBattle(boss));
        }

        executor.shutdown();
    }
}
