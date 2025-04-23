package school.faang.bjs2_72187;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Witcher {
    //Провести сравнение времени выполнения программы в однопоточном и многопоточном режимах,
    //а также при разном количестве потоков.

    private static final List<City> CITIES = List.of(
        new City("Kallax", new Location(3, 10)),
        new City("Bodviken", new Location(4, 6)),
        new City("Voxnan", new Location(5, 1)),
        new City("Holjesl", new Location(10, 7)),
        new City("Toftan", new Location(11, 1)),
        new City("Rimforsa", new Location(14, 2))
    );
    private static final List<Monster> MONSTERS = List.of(
        new Monster("Malm", new Location(1, 6)),
        new Monster("Brimnes", new Location(2, 2)),
        new Monster("Hauga", new Location(4, 8)),
        new Monster("Idanas", new Location(4, 11)),
        new Monster("Songesand", new Location(5, 4)),
        new Monster("Bruksvara", new Location(8, 9)),
        new Monster("Flintan", new Location(8, 6)),
        new Monster("Langfjall", new Location(9, 3)),
        new Monster("Laktare", new Location(11, 9)),
        new Monster("Kungsfors", new Location(12, 7)),
        new Monster("Sunnersta", new Location(12, 2)),
        new Monster("Hultarp", new Location(13, 4)),
        new Monster("Variera", new Location(15, 5)),
        new Monster("Hornavan", new Location(16, 1))
    );
    private static final Location WITCHER_LOCATION = new Location(0, 0);

    public static void main(String[] args) {
        executeTasks(Executors.newFixedThreadPool(1), "FixedThreadPool(1)");
        executeTasks(Executors.newFixedThreadPool(5), "FixedThreadPool(5)");
        executeTasks(Executors.newCachedThreadPool(), "CachedThreadPool");
    }

    private static void executeTasks(ExecutorService executor, String executorName) {
        long start = System.currentTimeMillis();
        for (City city : CITIES) {
            CityWorker cityWorker = new CityWorker(WITCHER_LOCATION, city, MONSTERS);
            executor.execute(cityWorker);
        }
        executor.shutdown();
        try {
            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
        }

        log.info("{}: work time is: {} millis", executorName, System.currentTimeMillis() - start);
    }
}
