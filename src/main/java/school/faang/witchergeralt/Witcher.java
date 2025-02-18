package school.faang.witchergeralt;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Witcher {
    private static final List<City> CITIES = List.of(
            new City("name", new Location(46, 568)),
            new City("name", new Location(626, 1236)),
            new City("name", new Location(446, 65)),
            new City("name", new Location(843, 223)),
            new City("name", new Location(1294, 757))
    );
    private static final List<Monster> MONSTERS = List.of(
            new Monster("Succubus", new Location(324, 235)),
            new Monster("Brooks", new Location(647, 757)),
            new Monster("Wolfhound", new Location(262, 234)),
            new Monster("Igosha", new Location(945, 4)),
            new Monster("Leshy", new Location(2356, 32)),
            new Monster("Demon", new Location(124, 897)),
            new Monster("Leaf", new Location(6, 54)),
            new Monster("Nacker", new Location(17, 437)),
            new Monster("Panther", new Location(588, 436)),
            new Monster("Varg", new Location(1644, 23))
    );
    private static final ExecutorService EXECUTOR_SERVICE = Executors.newFixedThreadPool(CITIES.size());
    private static final String PRINT_FORMAT_WITH_EXECUTOR = "Total execution time with executor: {} ms";
    private static final String PRINT_FORMAT_WITHOUT_EXECUTOR = "Total execution time without executor: {} ms";
    private static final String PRINT_FORMAT_EXECUTED = "Task is not completed within {} {}";
    private static final int TRANSFORMER_TO_MILLISECONDS = 1000000;
    private static final int TIME_EXECUTION = 1;
    private static final TimeUnit TIME_UNIT = TimeUnit.MINUTES;

    public static void main(String[] args) {
        Objects.requireNonNull(MONSTERS, "Monsters has not been initialized");
        Objects.requireNonNull(CITIES, "Cities has not been initialized");
        Objects.requireNonNull(EXECUTOR_SERVICE, "Executor has not been initialized");

        long startTime = System.nanoTime();
        CITIES.forEach(city -> new CityWorker(city, MONSTERS).run());
        long endTime = System.nanoTime();
        log.info(PRINT_FORMAT_WITHOUT_EXECUTOR, (endTime - startTime) / TRANSFORMER_TO_MILLISECONDS);

        try {
            startTime = System.nanoTime();
            CITIES.forEach(city -> EXECUTOR_SERVICE.submit(new CityWorker(city, MONSTERS)));
            EXECUTOR_SERVICE.shutdown();
            boolean isTerminated = EXECUTOR_SERVICE.awaitTermination(TIME_EXECUTION, TIME_UNIT);
            if (isTerminated) {
                endTime = System.nanoTime();
                log.info(PRINT_FORMAT_WITH_EXECUTOR, (endTime - startTime) / TRANSFORMER_TO_MILLISECONDS);
            } else {
                log.warn(PRINT_FORMAT_EXECUTED, TIME_EXECUTION, TIME_UNIT);
                EXECUTOR_SERVICE.shutdownNow();
            }
        } catch (InterruptedException exception) {
            log.error("Thread has been interrupted. {}\n{}", exception, Thread.currentThread().getName());
            Thread.currentThread().interrupt();
            EXECUTOR_SERVICE.shutdownNow();
        }
    }
}
