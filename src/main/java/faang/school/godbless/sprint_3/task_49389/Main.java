package faang.school.godbless.sprint_3.task_49389;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    private static final int NUMBER_OF_THREADS = 5;

    public static void main(String[] args) {
        Game game = new Game(100);

        ExecutorService executorService = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

        for (int i = 0; i < NUMBER_OF_THREADS; i++) {
            executorService.execute(() -> {
                while (!game.isGameOver()) {
                    boolean isScoreIncreased = Math.random() < 0.5;
                    boolean isLifeLost = Math.random() < 0.5;
                    game.update(isScoreIncreased, isLifeLost);
                }
            });
        }

        executorService.shutdown();

        try {
            if (executorService.awaitTermination(1, TimeUnit.MINUTES)) {
                System.out.println("Общий счёт за игру: " + game.getScore());
            }
        } catch (InterruptedException e) {
            System.out.println("Произошло исключение!" + e);
        }
    }
}
