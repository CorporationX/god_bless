package bigbang;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class BigBangTheory {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        Task sheldonTask = new Task("Sheldon", "preparing theory");
        Task leonardTask = new Task("Leonard", "modeling experiment");
        Task howardTask = new Task("Howard", "developing tools");
        Task rajeshTask = new Task("Rajesh", "analyzing data");

        executorService.submit(sheldonTask);
        executorService.submit(leonardTask);
        executorService.submit(howardTask);
        executorService.submit(rajeshTask);

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(5, TimeUnit.SECONDS)) {
                log.warn("Not all assignments finished in the expected time");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Main thread was interrupted while waiting for assignments to finish", e);
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }

        log.info("All assignments have been completed.");
    }
}
