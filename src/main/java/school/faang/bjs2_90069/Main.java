package school.faang.bjs2_90069;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int THREAD_POOL_SIZE = 5;
    private static final int TIME_WAITING = 5;
    private static final int TIME_UPDATE = 1000;

    public static void main(String[] args) {
        Player player1 = new Player(7, true, "player1");
        Player player2 = new Player(10, true, "player2");
        Player player3 = new Player(6, true, "player3");
        Player player4 = new Player(3, true, "player4");
        Player player5 = new Player(4, true, "player5");

        Game game = new Game();

        game.addPlayer(player1);
        game.addPlayer(player2);
        game.addPlayer(player3);
        game.addPlayer(player4);
        game.addPlayer(player5);

        ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        game.getPlayers().forEach(player -> {
            executor.submit(() -> {
                while (player.isAlive()) {
                    game.undate(player);
                    try {
                        Thread.sleep(TIME_UPDATE);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
        });

        executor.shutdown();

        try {
            if (!executor.awaitTermination(TIME_WAITING, TimeUnit.MINUTES)) {
                executor.shutdown();

            }
        } catch (InterruptedException e) {
            log.error("The game was interrupted", e);
        }
        log.info("Game over! Score:\n Points earned - {} \n Lives lost - {} ",
                game.getScore(), game.getLives());
    }
}
