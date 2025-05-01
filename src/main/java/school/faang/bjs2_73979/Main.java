package school.faang.bjs2_73979;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final ExecutorService executorService = Executors.newCachedThreadPool();
    private static final int TERMINATION_TIMEOUT = 10;

    public static void main(String[] args) {
        VladController controller = new VladController();
        List<TamagotchiVlad> tamagochis = List.of(
                new TamagotchiVlad(),
                new TamagotchiVlad(),
                new TamagotchiVlad(),
                new TamagotchiVlad(),
                new TamagotchiVlad(),
                new TamagotchiVlad()
        );
        tamagochis.forEach(controller::addVlad);
        List<Future<?>> futures = new ArrayList<>();
        futures.add(executorService.submit(controller::playAll));
        futures.add(executorService.submit(controller::feedAll));
        futures.add(executorService.submit(controller::cleanAll));
        futures.add(executorService.submit(controller::sleepAll));
        for (Future<?> future : futures) {
            try {
                future.get();
            } catch (InterruptedException | ExecutionException e) {
                log.error("Exception with message {} was thrown", e.getMessage());
                Thread.currentThread().interrupt();
            }
        }
        tamagochis.forEach(controller::removeVlad);
        dispose();
    }

    private static void dispose() {
        log.info("Start disposing executor service");
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(TERMINATION_TIMEOUT, TimeUnit.SECONDS)) {
                log.warn("Not all tasks was stopped successfully");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Interrupted exception with message {} was thrown", e.getMessage());
            executorService.shutdownNow();
        }
    }
}