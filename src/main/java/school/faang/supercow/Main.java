package school.faang.supercow;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int NUMBER_OF_PLAYERS = 10;
    private static final int BOSS_MAX_PLAYERS = 3;

    public static void main(String[] args) throws InterruptedException {
        Boss theDestroyer = new Boss(BOSS_MAX_PLAYERS, "The Destroyer");
        ExecutorService executorService = Executors.newFixedThreadPool(NUMBER_OF_PLAYERS);

        for (int i = 1; i <= NUMBER_OF_PLAYERS; i++) {
            String playerName = "Player-" + i;
            Player player = new Player(playerName);
            executorService.submit(() -> player.doBattle(theDestroyer));
        }
        executorService.shutdown();
        executorService.awaitTermination(15, TimeUnit.SECONDS);
    }
}