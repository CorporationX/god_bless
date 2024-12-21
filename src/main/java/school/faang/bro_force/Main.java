package school.faang.bro_force;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int user_count = 5;
        int standard_user_hp = 5;

        Game broForce = new Game();
        ExecutorService executor = Executors.newFixedThreadPool(user_count);

        for (int i = 1; i <= user_count; i++) {
            int copyI = i;
            executor.submit(() -> {
                Player player = new Player("V" + copyI, standard_user_hp);

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
