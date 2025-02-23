package school.faang.sprint.third.tamagochi;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final List<TamagotchiVlad> tamagotchiVlads = List.of(
            new TamagotchiVlad(),
            new TamagotchiVlad(),
            new TamagotchiVlad(),
            new TamagotchiVlad());

    public static void main(String[] args) {
        VladController vladController = new VladController();
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        executorService.submit(() -> vladController.playAll(tamagotchiVlads));
        executorService.submit(() -> vladController.feedAll(tamagotchiVlads));
        executorService.submit(() -> vladController.cleanAll(tamagotchiVlads));
        executorService.submit(() -> vladController.sleepAll(tamagotchiVlads));

        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(10000, TimeUnit.MILLISECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
