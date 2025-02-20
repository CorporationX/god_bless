package school.faang.supercow;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class Main {
    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        int maxPlayersInTheBattle = 2;
        Boss boss = new Boss(maxPlayersInTheBattle);
        Player[] players = {
                new Player("Archer"),
                new Player("Snowman"),
                new Player("Gaba"),
                new Player("Knight"),
        };
        // знаю, что не самая лучшая реализация, но ничего лучше особо не придумал
        // (только если принудительно убивать потоки после цикла)
        ExecutorService executor = Executors.newFixedThreadPool(2);
        int maxRound = 3;
        for (int round = 1; round <= maxRound; round++) {
            System.out.printf("Раунд ---%s--- начинается\n", round);

            for (Player player : players) {
                executor.execute(() -> player.doBattle(boss));
            }
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                LOGGER.severe(e.getMessage());
            }

        }
        executor.shutdown();

        int second = 5;
        try {
            if (!executor.awaitTermination(second, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            LOGGER.severe(e.getMessage());
        }

    }
}
