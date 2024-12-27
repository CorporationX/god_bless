package school.faang.task_bjs249691;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int MAX_FIGHTERS = 2;

    private static final int THREADS_COUNT = 4;

    public static void main(String[] args) {
        List<Player> players = Arrays.asList(new Player("Ксюша"), new Player("Кирилл"),
                new Player("Тимур"), new Player("Егор"));
        Boss boss = new Boss(MAX_FIGHTERS);
        ExecutorService executorService = Executors.newFixedThreadPool(THREADS_COUNT);

        for (Player player : players) {
            executorService.submit(() -> player.fightBoss(boss));
        }

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(30, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            System.out.println(e.getMessage());
            Thread.currentThread().interrupt();
        }
    }
}
