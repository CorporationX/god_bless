package school.faang.bjs248205;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Witcher {
    public static void main(String[] args) {

        List<City> cities = new ArrayList<>();
        cities.add(City.FOVOGRAD);
        cities.add(City.AXENFURT);
        cities.add(City.NIKIMA);
        cities.add(City.GDOAXEN);

        List<Monster> monsters = new ArrayList<>();
        monsters.add(new Monster("Griph", new Location(10.6, 15.1)));
        monsters.add(new Monster("Hriffen", new Location(235.0, 121.0)));
        monsters.add(new Monster("Cockatrice", new Location(124.5, 36.5)));
        monsters.add(new Monster("Chirtice", new Location(-374.0, 237.0)));

        long startTime = System.currentTimeMillis();

        ExecutorService executorService = Executors.newCachedThreadPool();

        for (City city : cities) {
            CityWorker worker = new CityWorker(city, monsters);
            executorService.submit(worker);
        }

        executorService.shutdown();
        long endTime = System.currentTimeMillis();
        log.info("Program execution time: {} ms", endTime - startTime);

        try {
            if (!executorService.awaitTermination(5, TimeUnit.SECONDS)) {
                log.info("The tasks were not completed in 5 seconds, stoped the ThreadPool forcefully");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("The main thread {} was interrupted while waiting",
                    Thread.currentThread().getName());
        }
    }
}