package school.faang.BJS2_61598;

import java.util.ArrayList;
import java.util.List;

public class BattleManager {
    public static void main(String[] args) {
        Boss boss = new Boss("Flamebringer", 3);
        List<Player> players = List.of(
                new Player("Bob"),
                new Player("Alice"),
                new Player("Charlie"),
                new Player("George"),
                new Player("Jack")
        );
        List<Thread> threads = new ArrayList<>();

        for (Player player : players) {
            threads.add(new Thread(() -> player.doBattle(boss)));
        }

        for (Thread thread : threads) {
            thread.start();
        }
    }
}
