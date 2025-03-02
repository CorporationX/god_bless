package school.faang.sprint3.multithreading.task_61957;

import school.faang.sprint3.multithreading.task_61957.util.ProbabilityBoolean;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static final int NUMBER_PLAYERS = 5;
    public static final int THREAD_NUMBER = 3;
    public static final int GAME_EVENTS = 20;
    public static final int AWAIT_TIMEOUT = 1;

    public static void main(String[] args) {
        Game myGame = Game.startNewGame();
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_NUMBER);
        for (int i = 0; i < NUMBER_PLAYERS; i++) {
            executorService.execute(() -> {
                for (int j = 0; j < GAME_EVENTS; j++) {
                    if (myGame.isGameOver()) {
                        return;
                    }
                    myGame.update(ProbabilityBoolean.getRandomPointEarn(), ProbabilityBoolean.getRandomLifeLost());
                }
            });
        }
        executorService.shutdown();
        try {
            if (executorService.awaitTermination(AWAIT_TIMEOUT, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
        System.out.println("\nAll threads stopped.");
    }
}

