package mod1sp3.tamagotchiVlad;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static final int THREAD_AMOUNT = 10;

    public static void main(String[] args) throws InterruptedException {
        VladController vladController = new VladController();
        TamagotchiVlad firstVlad = new TamagotchiVlad();
        TamagotchiVlad secondVlad = new TamagotchiVlad();
        vladController.addNewTamogotchi(firstVlad);
        vladController.addNewTamogotchi(secondVlad);

        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_AMOUNT);
        executorService.execute(vladController::playAll);
        executorService.execute(vladController::cleanAll);
        executorService.execute(vladController::sleepAll);
        executorService.execute(vladController::feedAll);

        try {
            if (executorService.awaitTermination(1, TimeUnit.MINUTES)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new IllegalStateException(e.getMessage(), e);
        }
    }
}
