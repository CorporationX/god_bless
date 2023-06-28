package supercow;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss("Huge beetle", 3);

        Player player1 = new Player("Dragonfly");
        Player player2 = new Player("Butterfly");
        Player player3 = new Player("Centipede");
        Player player4 = new Player("Grasshopper");
        Player player5 = new Player("Worm");

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(() -> player1.startBattle(boss));
        executorService.execute(() -> player2.startBattle(boss));
        executorService.execute(() -> player3.startBattle(boss));
        executorService.execute(() -> player4.startBattle(boss));
        executorService.execute(() -> player5.startBattle(boss));

        executorService.shutdown();

    }
}
