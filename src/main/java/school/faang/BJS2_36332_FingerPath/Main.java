package school.faang.BJS2_36332_FingerPath;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int SMALL_THREAD_POOL_SIZE = 2;
    private static final int BIG_THREAD_POOL_SIZE = 5;
    private static final int AWAIT_TERMINATION_SEC = 30;

    public static void main(String[] args) throws InterruptedException {
        List<City> cities = createCities();
        List<Monster> monsters = createMonsters();
        List<CityWorker> cityWorkers = cities.stream()
                .map(city -> new CityWorker(city, monsters))
                .toList();

        ExecutorService bigExecutor = Executors.newFixedThreadPool(BIG_THREAD_POOL_SIZE);
        ExecutorService smallExecutor = Executors.newFixedThreadPool(SMALL_THREAD_POOL_SIZE);

        for (int i = 0; i < 10; i++) {
            log.info("Iteration {}: ", i + 1);
            measureWorkingTime(() -> cityWorkers.forEach(CityWorker::run), "Single-thread execution time");
            measureWorkingTime(() -> submitTasksAndWait(cityWorkers, bigExecutor), "Execution time with 5 threads");
            measureWorkingTime(() -> submitTasksAndWait(cityWorkers, smallExecutor), "Execution time with 2 threads");
        }

        shutdownServices(smallExecutor, bigExecutor);
    }

    private static void measureWorkingTime(Runnable action, String message) {
        long startTime = System.nanoTime();
        action.run();
        long endTime = System.nanoTime();
        long actionDuration = endTime - startTime;
        log.info("{}: {} ns", message, actionDuration);
    }

    private static void submitTasksAndWait(List<CityWorker> cityWorkers, ExecutorService executor) {
        CompletableFuture<?>[] futureResults =
                cityWorkers.stream()
                        .map(cityWorker -> CompletableFuture.runAsync(cityWorker, executor))
                        .toArray(CompletableFuture[]::new);
        CompletableFuture.allOf(futureResults).join();
    }

    @SneakyThrows
    private static void shutdownServices(ExecutorService... executors) {
        for (ExecutorService executor: executors) {
            executor.shutdown();
            if (!executor.awaitTermination(AWAIT_TERMINATION_SEC, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        }
    }

    private static List<City> createCities() {
        List<City> cities = new ArrayList<>();
        cities.add(new City("Novigrad", new Location(10, 20)));
        cities.add(new City("Oxenfurt", new Location(-30, 40)));
        cities.add(new City("Vizima", new Location(15, -25)));
        cities.add(new City("Kaer Morhen", new Location(50, -10)));
        cities.add(new City("Toussaint", new Location(-35, 5)));
        return cities;
    }

    private static List<Monster> createMonsters() {
        List<Monster> monsters = new ArrayList<>();
        monsters.add(new Monster("Griffin", new Location(5, 10)));
        monsters.add(new Monster("Leshen", new Location(-20, 30)));
        monsters.add(new Monster("Wyvern", new Location(25, -15)));
        monsters.add(new Monster("Vampire", new Location(-40, -20)));
        monsters.add(new Monster("Drowner", new Location(30, 50)));
        monsters.add(new Monster("Werewolf", new Location(-10, 35)));
        monsters.add(new Monster("Striga", new Location(40, -30)));
        monsters.add(new Monster("Succubus", new Location(-25, -5)));
        monsters.add(new Monster("Chort", new Location(10, -10)));
        monsters.add(new Monster("Foglet", new Location(0, 0)));
        return monsters;
    }
}
