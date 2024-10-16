package school.faang.multithreading.parallelism.way.with.your.finger;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Witcher {
    private final static int THREAD_POOL_SIZE = 4;

    @SneakyThrows
    public static void main(String[] args) {
        List<City> cities = Arrays.asList(
                new City("City1", new Location(0, 50)),
                new City("City2", new Location(50, 0)),
                new City("City3", new Location(90, 70)),
                new City("City4", new Location(30, 170)),
                new City("City5", new Location(50, 100)),
                new City("City6", new Location(170, 90))
        );

        List<Monster> monsters = Arrays.asList(
                new Monster("Monster1", new Location(20, 35)),
                new Monster("Monster2", new Location(100, 140)),
                new Monster("Monster3", new Location(130, 150)),
                new Monster("Monster4", new Location(120, 160)),
                new Monster("Monster5", new Location(230, 230))
        );

        long startTime = System.currentTimeMillis();
        cities.forEach(city -> new CityWorker(city, monsters).run());
        long endTime = System.currentTimeMillis();

        long parallelStartTime = System.currentTimeMillis();
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        cities.forEach(city -> executor.submit(new CityWorker(city, monsters)));
        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);
        long parallelEndTime = System.currentTimeMillis();

        log.info("Выполнение в обычном режиме: {} ms", endTime - startTime);
        log.info("Выполнение в параллельном режиме, 4 потока: {} ms", parallelEndTime - parallelStartTime);
    }
}
