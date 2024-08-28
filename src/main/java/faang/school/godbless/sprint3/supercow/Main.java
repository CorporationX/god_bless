package faang.school.godbless.sprint3.supercow;

import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final int MAX_BATTLEFIELD_SIZE = 4;

    public static void main(String[] args) {
        List<Player> players = List.of(new Player("Player 1"),
                new Player("Player 2"),
                new Player("Player 3"),
                new Player("Player 4"),
                new Player("Player 5"),
                new Player("Player 6"),
                new Player("Player 7"),
                new Player("Player 8"),
                new Player("Player 9"),
                new Player("Player 10"));
        Boss boss = new Boss(new HashSet<>(), MAX_BATTLEFIELD_SIZE);
        ExecutorService executor = Executors.newCachedThreadPool();
        players.forEach(player -> executor.execute(() -> {
            try {
                player.startBattle(boss);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }));
        executor.shutdown();
    }
}
