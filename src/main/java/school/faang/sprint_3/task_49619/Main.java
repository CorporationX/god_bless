package school.faang.sprint_3.task_49619;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int MAX_PLAYERS = 10;
    private static final int AMOUNT_OF_PLAYERS = 30;
    private static final int AWAIT_DELAY = 1;

    public static void main(String[] args) {
        Boss boss = new Boss(MAX_PLAYERS);
        ExecutorService executorService = Executors.newFixedThreadPool(AMOUNT_OF_PLAYERS);

        for (int i = 1; i <= AMOUNT_OF_PLAYERS; i++) {
            int finalI = i;
            executorService.submit(() -> new Player("Player " + finalI).startBattle(boss));
        }

        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(AWAIT_DELAY, TimeUnit.MINUTES)) {
                System.out.println("Await timed out. Shutting down...");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted. Shutting down...");
            executorService.shutdownNow();
        }
    }
}
