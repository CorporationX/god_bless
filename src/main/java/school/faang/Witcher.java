package school.faang;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Witcher {
    private static final int THREAD_COUNT = 3;
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

        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_COUNT);
        for (City city : cities) {
            executorService.submit(new CityWorker(city, monsters));
        }
        executorService.shutdown();
        try {
            if (executorService.awaitTermination(TIMEOUT_SECONDS, TimeUnit.SECONDS)) {
                System.out.println("Calculations haven't been completed in time.");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
        System.out.println("All calculations have been completed.");
    }
}
