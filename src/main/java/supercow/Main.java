package supercow;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final int PLAYERS = 4;

    public static void main(String[] args) {
        Boss boss = new Boss(PLAYERS);

        Player player1 = new Player("Ivan");
        Player player2 = new Player("Viktor");
        Player player3 = new Player("Polina");
        Player player4 = new Player("Anya");
        Player player5 = new Player("Pavel");
        Player player6 = new Player("Igor");

        ExecutorService executor = Executors.newFixedThreadPool(PLAYERS);
        executor.submit(() -> player1.startBattle(boss));
        executor.submit(() -> player2.startBattle(boss));
        executor.submit(() -> player3.startBattle(boss));
        executor.submit(() -> player4.startBattle(boss));
        executor.submit(() -> player5.startBattle(boss));
        executor.submit(() -> player6.startBattle(boss));
        executor.shutdown();
    }
}
