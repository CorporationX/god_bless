package faang.school.godbless.alexbulgakoff.multithreading.synchronization.broforce;

import lombok.SneakyThrows;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Alexander Bulgakov
 */

public class Main {
    static final int COUNT_PLAYERS = 3;
    static final int PLAYER_MAX_LIVE = 5;
    static final int COUNT_THREADS = 3;

    @SneakyThrows
    public static void main(String[] args) {
        Game game = new Game();

        Player player1 = new Player("firstPlayer", PLAYER_MAX_LIVE);
        Player player2 = new Player("secondPlayer", PLAYER_MAX_LIVE);

        game.addPlayer(player1);
        game.addPlayer(player2);

        ExecutorService executorService = Executors.newFixedThreadPool(COUNT_THREADS);

        for (int i = 0; i < game.getPlayerList().size(); i++) {
            executorService.submit(() -> {
                while (player1.getHealth() > 0 && player2.getHealth() > 0) {
                    boolean gameIsRunning = game.update();
                    System.out.println("Is anyone dead? " + gameIsRunning);
                }
            });
        }

        executorService.shutdown();
    }
}
