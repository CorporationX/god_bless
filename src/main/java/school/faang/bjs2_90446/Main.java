package school.faang.bjs2_90446;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int AWAIT_TERMINATION = 1;

    public static void main(String[] args) {
        Boss boss = new Boss(3);

        Player[] players = new Player[] {
                new Player("Player 1"),
                new Player("Player 2"),
                new Player("Player 3"),
                new Player("Player 4")
        };

        ExecutorService threads = Executors.newFixedThreadPool(3);

        for (int i = 0; i < players.length; i++) {
            int finalI = i;
            threads.submit(() -> players[finalI].doBattle(boss));
        }

        threads.shutdown();

        try {
            if (!threads.awaitTermination(AWAIT_TERMINATION, TimeUnit.MINUTES)) {
                threads.shutdownNow();
            }
        } catch (InterruptedException e) {
            threads.shutdownNow();
        }
    }
}
