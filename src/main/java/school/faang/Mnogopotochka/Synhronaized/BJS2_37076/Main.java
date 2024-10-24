package school.faang.Mnogopotochka.Synhronaized.BJS2_37076;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int NUMBER_THREADS = 3;
    private static final Random random = new Random();
    private static List<Player> players = new ArrayList<>();
    private static ExecutorService executorService = Executors.newFixedThreadPool(NUMBER_THREADS);
    static Game game = new Game();


    public static void main(String[] args) {
        addPlayer("Lexa");
        addPlayer("Dima");
        addPlayer("Vika");
        addPlayer("Biba");

        startGame();
        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                log.error("Executor service did not terminate within the specified time.");
                throw new IllegalStateException("Executor service did not terminate within the specified time.");
            }
        } catch (InterruptedException e) {
            log.error("Executor service was interrupted", e);
            Thread.currentThread().interrupt();
        }
    }

    private static void startGame() {
        players.forEach(player -> {
            for (int i = 0; i < 10; i++) {
                executorService.submit(() -> game.update(player, getEvent()));
            }
        });
    }

    private static boolean getEvent() {
        return random.nextInt(2) == 1;
    }

    private static void addPlayer(String name) {
        players.add(new Player(name));
    }
}
