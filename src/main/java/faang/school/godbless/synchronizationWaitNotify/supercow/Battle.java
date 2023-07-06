package faang.school.godbless.synchronizationWaitNotify.supercow;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Battle {
    private static final int NUMBER_OF_THREADS = 5;
    private static final int MAX_NUMBER_OF_PLAYERS = 3;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
        Boss boss = new Boss(MAX_NUMBER_OF_PLAYERS);

        List<Player> players = List.of(
                new Player("John"),
                new Player("Liza"),
                new Player("Robert"),
                new Player("Maxim"),
                new Player("Bob"),
                new Player("Lena"),
                new Player("Alex")
        );

        for (Player player : players) {
            executorService.execute(() -> player.startBattle(boss));
        }

        try {
            executorService.awaitTermination(1, TimeUnit.SECONDS);

            for (Player player : players) {
                executorService.execute(() -> player.completeBattle(boss));
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        executorService.shutdown();
    }
}
