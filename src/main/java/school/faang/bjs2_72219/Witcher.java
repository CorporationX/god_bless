package school.faang.bjs2_72219;

import lombok.extern.slf4j.Slf4j;
import school.faang.bjs2_72219.model.City;
import school.faang.bjs2_72219.model.CityWorker;
import school.faang.bjs2_72219.model.Location;
import school.faang.bjs2_72219.model.Monster;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Witcher {
    private static final ExecutorService executorService = Executors.newCachedThreadPool();
    private static final int TERMINATION_TIMEOUT = 30;

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

        List<CityWorker> cityWorkers = cities.stream()
                .map(city -> new CityWorker(city, monsters))
                .toList();

        long before = System.currentTimeMillis();
        cityWorkers.forEach(executorService::execute);
        dispose();
        long after = System.currentTimeMillis();
        log.info("Duration with concurrency: {} ms.", after - before);

        before = System.currentTimeMillis();
        cityWorkers.forEach(CityWorker::run);
        after = System.currentTimeMillis();
        log.info("Duration without concurrency: {} ms.", after - before);
    }

    private static void dispose() {
        log.info("Start disposing");
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(TERMINATION_TIMEOUT, TimeUnit.SECONDS)) {
                log.warn("Not all tasks successfully finished");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Interrupted exception with message {} was thrown", e.getMessage());
            executorService.shutdownNow();
        }
    }
}