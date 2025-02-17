package school.faang.witchergeralt;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
    private static final int TRANSFORMER_TO_MILLISECONDS = 1000000;

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        CITIES.forEach(city -> new CityWorker(city, MONSTERS).run());
        long endTime = System.nanoTime();
        log.info(PRINT_FORMAT_WITHOUT_EXECUTOR, (endTime - startTime) / TRANSFORMER_TO_MILLISECONDS);

        try {
            startTime = System.nanoTime();
            if (!CITIES.isEmpty()) {
                CITIES.forEach(city -> EXECUTOR_SERVICE.submit(new CityWorker(city, MONSTERS)));
            } else {
                throw new IllegalArgumentException("No cities found");
            }
            while (!EXECUTOR_SERVICE.isTerminated()) {
                EXECUTOR_SERVICE.shutdown();
            }
            endTime = System.nanoTime();
            log.info(PRINT_FORMAT_WITH_EXECUTOR, (endTime - startTime) / TRANSFORMER_TO_MILLISECONDS);
        } catch (Exception exception) {
            log.error(exception.getMessage(), exception);
        }
    }
}
