package pave.the.way;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Witcher {
    private static final int AWAITING_SECONDS = 5;
    private static final List<City> CITIES =
            List.of(new City("Washington", new Location(602.60, 304.25)),
                    new City("New York", new Location(501.45, 370.86)),
                    new City("Miami", new Location(120.75, 250.76)));
    private static final List<Monster> MONSTERS =
            List.of(new Monster("Megalodon", new Location(300.28, 156.78)),
                    new Monster("Godzilla", new Location(105.28, 175.78)),
                    new Monster("King Kong", new Location(208.00, 407.45)),
                    new Monster("Kaiju", new Location(402.08, 204.41)));

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (City city : CITIES) {
            executorService.submit(new CityWorker(city, MONSTERS));
        }

        smoothShutdown(executorService);
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        log.info("Program was executed in {} milliseconds", duration);
    }

    private static void smoothShutdown(ExecutorService executor) {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(AWAITING_SECONDS, TimeUnit.SECONDS)) {
                log.warn("Execution is not terminated in time. Forced shutdown!");
                executor.shutdownNow();
            } else {
                log.info("Execution is terminated successful!");
            }
        } catch (InterruptedException e) {
            log.error("Principal Thread is interrupted");
            executor.shutdownNow();
        }
    }
}
