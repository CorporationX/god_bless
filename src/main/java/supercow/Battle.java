package supercow;

import java.util.ArrayList;
import java.util.List;

public class Battle {
    public static void main(String[] args) throws InterruptedException {
        Boss boss = new Boss(2);

        List<Player> players = List.of(
                new Player("Player 1"),
                new Player("Player 2"),
                new Player("Player 3"),
                new Player("Player 4"),
                new Player("Player 5")
        );

        List<Thread> threads = new ArrayList<>();

        for (Player player : players) {
            Thread thread = new Thread(() -> {
                try {
                    player.doBattle(boss);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("Battle simulation complete.");
    }
}
