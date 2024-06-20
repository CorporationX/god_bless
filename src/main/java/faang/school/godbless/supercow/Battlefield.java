package faang.school.godbless.supercow;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Battlefield {
    public static void main(String[] args) {
        Boss boss = new Boss();
        List<Player> players = List.of(
                new Player("Player 1"), new Player("Player 2"),
                new Player("Player 3"), new Player("Player 4"),
                new Player("Player 5"), new Player("Player 6")
        );

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (Player player : players) {
            executorService.execute(() -> player.startBattle(boss));
        }

        executorService.shutdown();
    }
}
