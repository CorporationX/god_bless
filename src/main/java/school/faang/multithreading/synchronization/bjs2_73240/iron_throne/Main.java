package school.faang.multithreading.synchronization.bjs2_73240.iron_throne;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    private static final int THREADS_AMOUNT = 5;

    public static void main(String[] args) {
        House house = new House(new ArrayList<>(List.of(Role.values())));
        ExecutorService executorService = Executors.newFixedThreadPool(THREADS_AMOUNT);

        IntStream.range(0, THREADS_AMOUNT).forEach(i -> {
            String userName = String.format("user%d", i);
            User user = new User(userName);
            executorService.submit(() -> {
                user.joinHouse(house);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    log.error("Exception during sleep, error = {}", e.getMessage());
                    Thread.currentThread().interrupt();
                }
                user.leaveHouse(house);
            });
        });

        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(15, TimeUnit.SECONDS)) {
                log.warn("Force Termination.");
                executorService.shutdownNow();
            } else {
                log.info("Execution is successfully finished.");
            }
        } catch (InterruptedException e) {
            log.error("Force Termination. InterruptedException = {}", e.getMessage());
            executorService.shutdownNow();
        }
        house.printRoles();
    }
}
