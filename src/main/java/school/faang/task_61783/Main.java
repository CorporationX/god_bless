package school.faang.task_61783;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int WAIT_TIME = 1;

    public static void main(String[] args) {
        Game game = new Game();

        ExecutorService executor = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 50; i++) {
            executor.execute(() -> playGame(game));
            executor.execute(() -> playGame(game));
            executor.execute(() -> playGame(game));
            executor.execute(() -> playGame(game));
            executor.execute(() -> playGame(game));
        }

        executor.shutdown();
        try {
            if (!executor.awaitTermination(WAIT_TIME, TimeUnit.MINUTES)) {
                System.out.println("Не все задачи успели выполниться за отведённое время!");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Основной поток прерван");
            throw new RuntimeException(e);
        } finally {
            if (!executor.isTerminated()) {
                executor.shutdownNow();
            }
        }
    }

    private static void playGame(Game game) {
        boolean isScoresIncrease = Math.random() > 0.5;
        boolean isLivesDecrease = Math.random() > 0.7;

        game.update(isScoresIncrease, isLivesDecrease);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.printf("Ожидание потока \"%s\" прервано%n", Thread.currentThread().getName());
            throw new RuntimeException(e);
        }
    }
}
