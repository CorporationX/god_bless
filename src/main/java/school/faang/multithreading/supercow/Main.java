package school.faang.multithreading.supercow;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Boss boss = new Boss(3);

        Player player1 = new Player("John");
        Player player2 = new Player("Jane");
        Player player3 = new Player("Bob");
        Player player4 = new Player("Phil");

        List<Player> players = List.of(player1, player2, player3, player4);

        ExecutorService executor = Executors.newCachedThreadPool();
        for (Player player : players) {
            executor.execute(() -> {
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
