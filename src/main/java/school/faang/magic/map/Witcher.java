package school.faang.magic.map;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Witcher {
    public static void main(String[] args) {
        Monster himera = new Monster("Химера", new Location(0, 4));
        Monster vampire = new Monster("Вампир", new Location(1, 6));
        Monster cyclop = new Monster("Циклоп", new Location(4, 7));
        Monster silvan = new Monster("Леший", new Location(3, 14));
        Monster troll = new Monster("Троль", new Location(5, 0));
        Monster ghost = new Monster("Призрак", new Location(4, 3));

        City novigrad = new City("Новиград", new Location(1, 4));
        City ochsenfurt = new City("Оксененфурт", new Location(4, 1));
        City blaviken = new City("Блавикен", new Location(3, 8));
        List<City> cities = List.of(novigrad, ochsenfurt, blaviken);

        CityWorker novigradWorker = new CityWorker(novigrad, List.of(himera, vampire));
        CityWorker ochsenfurtWorker = new CityWorker(ochsenfurt, List.of(cyclop, silvan));
        CityWorker blavikenWorker = new CityWorker(blaviken, List.of(troll, ghost));
        List<CityWorker> workers = List.of(novigradWorker, ochsenfurtWorker, blavikenWorker);

        executeInSingleThread(workers);
        System.out.println();

        executeParallel(workers, cities.size());
        System.out.println();

        executeParallel(workers, 5);
        System.out.println();
    }

    private static void executeInSingleThread(List<CityWorker> workers) {
        long startTime = System.currentTimeMillis();
        workers.forEach(CityWorker::run);
        long endTime = System.currentTimeMillis();
        System.out.println("Время однопоточного выполнения программы: " + (endTime - startTime) + "ms");
    }

    private static void executeParallel(List<CityWorker> workers, int threadCount) {
        long startTime = System.currentTimeMillis();
        ExecutorService executor = Executors.newFixedThreadPool(threadCount);
        workers.forEach(executor::submit);

        executor.shutdown();
        try {
            if (executor.awaitTermination(10, TimeUnit.SECONDS)) {
                long endTime = System.currentTimeMillis();
                System.out.println("Время выполнения программы в " + threadCount + " потоках: " + (endTime - startTime) + "ms");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            log.error(e.getMessage());
            log.error(Arrays.toString(e.getStackTrace()));
        }
    }
}
