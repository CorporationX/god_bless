package school.faang.bro_force;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int USER_COUNT = 5;
    private static final int STANDARD_USER_HP = 5;

    public static void main(String[] args) {

        Game broForce = new Game();
        ExecutorService executor = Executors.newFixedThreadPool(USER_COUNT);

        for (int i = 1; i <= USER_COUNT; i++) {
            int copyI = i;
            executor.submit(() -> {
                Player player = new Player("V" + copyI, STANDARD_USER_HP);

                broForce.update(Action.PLAYER_JOIN, player);
                broForce.update(Action.PLAYER_SCORE_UP, player);

                try {
                    Thread.sleep(150);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                broForce.update(Action.PLAYER_WAS_ATTACKED, player, 5);
            });
        }

        executor.shutdown();

        try {
            if (executor.awaitTermination(5, TimeUnit.SECONDS)) {
                System.out.println("Mission complete");
            } else {
                System.out.println("Something went wrong...");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Thread was interrupted " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
