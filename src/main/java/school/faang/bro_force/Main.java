package school.faang.bro_force;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int userCount = 5;
        int standardUserHp = 5;

        Game broForce = new Game();
        ExecutorService executor = Executors.newFixedThreadPool(userCount);

        for (int i = 1; i <= userCount; i++) {
            int copyI = i;
            executor.submit(() -> {
                Player player = new Player("V" + copyI, standardUserHp);

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

        if (executor.awaitTermination(5, TimeUnit.SECONDS)) {
            System.out.println("Mission complete");
        } else {
            System.out.println("Something went wrong...");
        }
    }
}
