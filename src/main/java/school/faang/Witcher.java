package school.faang;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Witcher {
    private static final Logger logger = LoggerFactory.getLogger(Witcher.class);
    private static final int TIMEOUT_SECONDS = 10;

    public static void main(String[] args) {
        List<City> cities = List.of(
                new City("Novigrad", new Location(0, 60)),
                new City("Oxenfurt", new Location(60, 0)),
                new City("Vizima", new Location(120, 50)),
                new City("Kaer Morhen", new Location(180, 70))
        );
        List<Monster> monsters = List.of(
                new Monster("Griffin", new Location(10, 15)),
                new Monster("Basilisk", new Location(235, 121)),
                new Monster("Cockatrice", new Location(-124, 36)),
                new Monster("Chort", new Location(374, -237))
        );

        int[] threadCounts = {1, 2, 3, 4};

        for (int threads : threadCounts) {
            logger.info("Running with {} threads...", threads);
            runWithThreads(cities, monsters, threads);
        }
    }

    private static void runWithThreads(List<City> cities, List<Monster> monsters, int threadCount) {
        ExecutorService executorService = Executors.newFixedThreadPool(threadCount);
        final long startTime = System.nanoTime();

        for (City city : cities) {
            executorService.submit(new CityWorker(city, monsters));
        }
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(TIMEOUT_SECONDS, TimeUnit.SECONDS)) {
                logger.info("Calculations haven't been completed in time.");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            logger.error("Shutdown interrupted.");
            throw new RuntimeException(e);
        }
        logger.info("Execution time with {} threads: {} ns", threadCount, System.nanoTime() - startTime);
    }
}
