package faang.school.godbless.tamagotchi;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int THREAD_POOL_SIZE = 3;

    public static void main(String[] args) {
        VladController vladController = new VladController();
        TamagotchiVlad tamagotchiVlad1 = new TamagotchiVlad("Test1");
        TamagotchiVlad tamagotchiVlad2 = new TamagotchiVlad("Test2");
        TamagotchiVlad tamagotchiVlad3 = new TamagotchiVlad("Test3");
        vladController.addNewTamogotchi(tamagotchiVlad1);
        vladController.addNewTamogotchi(tamagotchiVlad2);
        vladController.addNewTamogotchi(tamagotchiVlad3);

        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        for (int i = 0; i < THREAD_POOL_SIZE; i++) {
            executorService.execute(vladController::feedAll);
            executorService.execute(vladController::sleepAll);
            executorService.execute(vladController::playAll);
            executorService.execute(vladController::cleanAll);
            if (i == 1) {
                executorService.execute(() -> vladController.removeTamagotchi(tamagotchiVlad1));
                executorService.execute(() -> vladController.removeTamagotchi(tamagotchiVlad2));
            }
        }

        executorService.shutdown();
        try {
            executorService.awaitTermination(10, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}