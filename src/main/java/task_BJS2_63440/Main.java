package task_BJS2_63440;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss(2);
        List<Player> players = List.of(
                new Player("Sam"),
                new Player("Mike"),
                new Player("Liza"),
                new Player("Ira"),
                new Player("Tony")
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
