package school.faang.tamagochi;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    private static final int NUMBER_OF_VLAD = 5;
    private static final int NUMBER_OF_THREADS = 8;

    public static void main(String[] args) {
        VladController controller = new VladController();

        for (int i = 0; i < NUMBER_OF_VLAD; i++) {
            TamagotchiVlad vlad = new TamagotchiVlad("Vlad " + i);
            controller.addVlad(vlad);
        }

        ExecutorService executorService = Executors.newFixedThreadPool(8);
        for (int i = 0; i < NUMBER_OF_THREADS; i++) {
            executorService.submit(() -> {
                controller.feedAll();
                controller.cleanAll();
                controller.sleepAll();
                controller.playAll();
            });
        }
        executorService.shutdown();
    }
}
