package school.faang.bjs49331;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    public static final Random RANDOM = new Random();

    public static void main(String[] args) {
        Game game = initRandomGame();
        final int numberOfPlayers = game.getTotalPlayers();
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for (int i = 0; i < numberOfPlayers; i++) {
            int leftBros = game.getPlayersLeft();
            executorService.submit(() -> {
                while(!game.isGameOver()) {
                    game.update(Bro::battle, RANDOM.nextInt(leftBros), RANDOM.nextInt(leftBros));
                }
            });
        }

        executorService.shutdown();
        try {
            if (executorService.awaitTermination(10, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("While waiting to shutdown {}", e.getMessage());
        }
        System.out.println("Total score: " + game.getScore() + ". Total deaths: " + game.getLives());
    }

    public static Game initRandomGame() {
        List<Bro> bros = new ArrayList<>(
                List.of(
                        new Bro("Abdul"),
                        new Bro("Bega"),
                        new Bro("Arseni"),
                        new Bro("Alex")
                )
        );
        return new Game(bros);
    }
}
