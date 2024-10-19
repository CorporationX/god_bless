package school.faang.Mnogopotochka.ParallelismThread.BJS2_36308;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private final static int COUNT_THREADS = 5;
    private static List<City> cityList = new ArrayList<>(Arrays.asList(
            new City("Camelot", new Location(10.0, 20.0)),
            new City("Vinterhold", new Location(15.0, 25.0))
    ));
    private static List<Monster> monsterList = new ArrayList<>(Arrays.asList(
            new Monster("Viverna", new Location(35.0, 45.0)),
            new Monster("Dragon", new Location(40.0, 50.0)),
            new Monster("Troll", new Location(45.0, 55.0)),
            new Monster("Goblin", new Location(50.0, 60.0)),
            new Monster("Orc", new Location(55.0, 65.0))
    ));

    public static void main(String[] args) throws InterruptedException {
        executeWithThreadPool();
        executeWithSingleThread();
    }

    private static void executeWithThreadPool() throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(COUNT_THREADS);
        double startTime = System.currentTimeMillis();
        cityList.forEach(city -> executorService.submit(new CityWorker(city, monsterList)));
        executorService.shutdown();
        if (executorService.awaitTermination(60, TimeUnit.SECONDS)) {
            double endTime = System.currentTimeMillis();
            log.info(String.format("Total execution time with thread pool: %.4f seconds", (endTime - startTime) / 1000.0));
        } else {
            log.warn("Execution interrupted");
        }
    }

    private static void executeWithSingleThread() throws InterruptedException {
        double startTime = System.currentTimeMillis();
        Thread thread = new Thread(() -> cityList.forEach(city -> new CityWorker(city, monsterList).run()));
        thread.start();
        thread.join();
        double endTime = System.currentTimeMillis();
        log.info(String.format("Total execution time with one thread: %.4f seconds", (endTime - startTime) / 1000.0));
    }
}
