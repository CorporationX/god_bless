package school.faang.sprint_3.task_49549;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int NUMBER_OF_THREADS = 4;
    private static final int NUMBER_OF_VLADS = 2;
    private static final int NUMBER_OF_GAME_SESSIONS = 5;
    private static final int AWAIT_TIME = 1;


    public static void main(String[] args) {
        List<TamagotchiVlad> tamagotchiVlads = new ArrayList<>();
        for (int i = 1; i <= NUMBER_OF_VLADS; i++) {
            tamagotchiVlads.add(new TamagotchiVlad("Vlad " + i));
        }

        VladController vladController = new VladController(tamagotchiVlads);
        ExecutorService executorService = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

        for (int i = 1; i <= NUMBER_OF_GAME_SESSIONS; i++) {
            executorService.submit(() -> {
                vladController.feedAll();
                vladController.sleepAll();
                vladController.cleanAll();
                vladController.playAll();
            });
        }

        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(AWAIT_TIME, TimeUnit.MINUTES)) {
                System.out.println("Await timed out. Shutting down...");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted. Shutting down...");
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
