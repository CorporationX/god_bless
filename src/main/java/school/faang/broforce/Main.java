package school.faang.broforce;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int N_TREADS = 3;

    public static void main(String[] args) {
        List<Player> players = new ArrayList<>(Arrays.asList(
                new Player("Dimasik", 6),
                new Player("Timofey", 5),
                new Player("Maksim", 8)
        ));
        Game game = new Game(players);
        System.out.println("Total number of lives: " + game.getLives());
        game.startGame();
        ExecutorService executorService = Executors.newFixedThreadPool(N_TREADS);
        for (Player player : game.getPlayers()) {
            executorService.submit(() -> player.play(game));
        }
        executorService.shutdown();
        if (game.isGameStart() == false) {
            try {
                if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                    executorService.shutdownNow();
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
                log.error("Caught exception: ", e);
            }
        }
    }
}
