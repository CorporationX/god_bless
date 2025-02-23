package school.faang.sprint.third.tamagochi;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final List<TamagotchiVlad> TAMAGOTCHI_VLADS = new ArrayList<>();
    private static final int TERMINATION_TIMEOUT = 10000;

    static {
        for (int i = 0; i < 4; i++) {
            TAMAGOTCHI_VLADS.add(new TamagotchiVlad());
        }
    }

    public static void main(String[] args) {
        VladController vladController = new VladController();
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        executorService.submit(() -> vladController.playAll(TAMAGOTCHI_VLADS));
        executorService.submit(() -> vladController.feedAll(TAMAGOTCHI_VLADS));
        executorService.submit(() -> vladController.cleanAll(TAMAGOTCHI_VLADS));
        executorService.submit(() -> vladController.sleepAll(TAMAGOTCHI_VLADS));

        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(TERMINATION_TIMEOUT, TimeUnit.MILLISECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Thread interrupted: {}", e.getMessage());
            Thread.currentThread().interrupt();
        }
    }
}
