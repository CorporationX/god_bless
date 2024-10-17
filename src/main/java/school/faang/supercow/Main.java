package school.faang.supercow;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final int NUM_THREADS = 4;
    public static void main(String[] args) {
        Player player1 = new Player("Arthur");
        Player player2 = new Player("Ludwig");
        Player player3 = new Player("Sven");
        List<Player> players = List.of(player1, player2, player3);
        Boss boss = new Boss(2);
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);
        for (Player player : players) {
            executor.submit(() -> {
                try {
                    player.startBattle(boss);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        executor.shutdown();
    }
}
