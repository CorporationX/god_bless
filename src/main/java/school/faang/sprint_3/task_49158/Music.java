package school.faang.sprint_3.task_49158;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Music {
    private static final int AMOUNT_OF_USERS = 10;
    private static final int AWAITING_DELAY = 1;
    private static final Player PLAYER = new Player();

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(AMOUNT_OF_USERS);
        for (int i = 0; i < AMOUNT_OF_USERS; i++) {
            executorService.submit(() -> {
                PLAYER.play();
                PLAYER.skip();
                PLAYER.pause();
                PLAYER.previous();
            });
        }
        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(AWAITING_DELAY, TimeUnit.MINUTES)) {
                System.out.println("Awaiting time out. Shutting down...");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            System.out.println("Awaiting interrupted. Shutting down...");
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
