package school.faang.task_48194;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Witcher {
    private static long startTime;

    public static Location LOCATION = new Location(0, 0);

    public static void main(String[] args) throws InterruptedException {
        List<City> cities = new ArrayList<>();
        cities.add(City.NOVIGRAD);
        cities.add(City.OXENFURT);
        cities.add(City.VIZIMA);
        cities.add(City.KAER_MORHEN);

        List<Monster> monsters = new ArrayList<>();
        monsters.add(new Monster("Griffin", new Location(10, 15)));
        monsters.add(new Monster("Basilisk", new Location(235, 121)));
        monsters.add(new Monster("Cockatrice", new Location(-124, 36)));
        monsters.add(new Monster("Chort", new Location(374, -237)));

        ExecutorService executorService = Executors.newFixedThreadPool(Config.FIXED_THREAD_POOL_SIZE);

        startTime = System.currentTimeMillis();
        for (City city : cities) {
            executorService.execute(new CityWorker(city, monsters));
        }

        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);

        log.info("All tasks are completed! Execution time: {}", System.currentTimeMillis() - startTime);
    }
}
