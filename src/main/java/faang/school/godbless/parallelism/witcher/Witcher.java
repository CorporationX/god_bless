package faang.school.godbless.parallelism.witcher;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Witcher {

    public static final int MAX_KILL_TIME = 60;
    public static final int MIN_KILL_TIME = 10;
    public static final int N_THREADS = 1;

    public static void main(String[] args) {
        List<Monster> monsters = new ArrayList<>();

        monsters.add(new Monster("Griffin", "Novigrad", new Location(5, 65)));
        monsters.add(new Monster("Basilisk", "Oxenfurt", new Location(65, 5)));
        monsters.add(new Monster("Cockatrice", "Novigrad", new Location(3, 62)));
        monsters.add(new Monster("Chort", "Novigrad", new Location(7, 63)));


        List<City> cities = new ArrayList<>();

        cities.add(new City("Novigrad", new Location(0, 60), 180));
        cities.add(new City("Oxenfurt", new Location(60, 0), 70));
        cities.add(new City("Vizima", new Location(120, 50), 30));
        cities.add(new City("Kaer Morhen", new Location(180, 70), 0));


        ExecutorService magicMap = Executors.newFixedThreadPool(N_THREADS);

        log.info("Magic map begins processing list of cities.");
        long startTime = System.nanoTime();

        cities.forEach(city -> {
            var cityWorker = new CityWorker(city, monsters);

            magicMap.submit(cityWorker);
        });

        magicMap.shutdown();

        try {
            magicMap.awaitTermination((long) MAX_KILL_TIME * cities.size(), TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            log.error("Magic map processing was interrupted", e);
            return;
        }

        long endTime = System.nanoTime();

        long duration = (endTime - startTime) / 1_000_000_000;

        log.info("Total time spent by magic map to process all cities is: " + duration + " seconds.");

        //При запуске с N_THREADS = 2 время выполнения - 20 секунд
        //При запуске с N_THREADS = 1 время выполнения - 40 секунд
        //Логично
    }
}
