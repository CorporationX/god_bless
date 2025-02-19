package school.faang;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Player> players = List.of(
                new Player("Player 1"),
                new Player("Player 2"),
                new Player("Player 3"),
                new Player("Player 4")
        );

        Boss boss = new Boss(3);
        List<Thread> threads = new ArrayList<>();
        for (Player player : players) {
            threads.add(new Thread(() -> player.doBattle(boss)));
        }
        for (Thread thread : threads) {
            thread.start();
        }
    }
}
