package school.faang.BJS2_61793;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int THREAD_POOL_SIZE = 3;
    private static final int PLAYER_COUNT = 10;
    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        Game game = new Game(0, 5);
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        for (int i = 0; i < PLAYER_COUNT; i++) {
            boolean addPoint = RANDOM.nextBoolean();
            boolean loseLife = RANDOM.nextBoolean();
            executor.execute(() -> game.update(addPoint, loseLife));
        }
        executor.shutdown();
        try {
            if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                executor.shutdownNow();
                System.out.println("Игроки не успели закончить игру вовремя. Игра завершена.");
            }

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            executor.shutdownNow();
            System.out.println("Игра была внезапно прервана. Результаты текущей сессии аннулированы.");
        }
    }
}
