package school.faang.the_witcher;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int THREAD_POOL = 5;

    @SuppressWarnings("checkstyle:VariableDeclarationUsageDistance")
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        List<City> cities = new ArrayList<>();
        cities.add(new City("Novigrad", new Location(0, 60)));
        cities.add(new City("Oxenfurt", new Location(60, 0)));
        cities.add(new City("Vizima", new Location(120, 50)));
        cities.add(new City("Kaer Morhen", new Location(180, 70)));

        List<Monster> monsters = new ArrayList<>();
        monsters.add(new Monster("Griffin", new Location(10, 15)));
        monsters.add(new Monster("Basilisk", new Location(235, 121)));
        monsters.add(new Monster("Cockatrice", new Location(-124, 36)));
        monsters.add(new Monster("Chort", new Location(374, -237)));

        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL);

        for (City city : cities) {
            CityWorker cityWorker = new CityWorker(city, monsters);
            executorService.submit(cityWorker);
        }

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(1, TimeUnit.MINUTES)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }

        log.info("All tasks completed");

        long endTime = System.currentTimeMillis();
        System.out.println("Elapsed time: " + (endTime - startTime) + "ms");
    }
}
