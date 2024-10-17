package school.faang.supercow;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Game {
    private static final int THREAD_COUNT = 2;

    public static void main(String[] args) {
        Boss boss = new Boss("Циклоп", 2);
        ExecutorService service = Executors.newFixedThreadPool(THREAD_COUNT);

        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");
        Player player3 = new Player("Player 3");
        Player player4 = new Player("Player 4");

        service.submit(() -> player1.startBattle(boss));
        service.submit(() -> player2.startBattle(boss));
        service.submit(() -> player3.startBattle(boss));
        service.submit(() -> player4.startBattle(boss));

        service.shutdown();
        try {
            service.awaitTermination(20, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

    }
}
