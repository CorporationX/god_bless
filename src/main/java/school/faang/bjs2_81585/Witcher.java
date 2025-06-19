package school.faang.bjs2_81585;

import lombok.extern.slf4j.Slf4j;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Witcher {
    private static final int POOl_SIZE = 4;
    private static final int TIMEOUT = 10;
    private static long startTime;

    public static void main(String[] args) {

        List<City> cities = List.of(new City("Туссент", new Location()),
                                    new City("Скеллиге", new Location()),
                                    new City("Новиград", new Location()),
                                    new City("Оксенфурт", new Location()));

        List<Monster> monsters = List.of(new Monster("Полуночница", new Location()),
                                         new Monster("Полуденница", new Location()),
                                         new Monster("Гуль", new Location()),
                                         new Monster("Брукса", new Location()),
                                         new Monster("Васелиск", new Location()),
                                         new Monster("Утопец", new Location()),
                                         new Monster("Стрыга", new Location()),
                                         new Monster("Гаргулья", new Location()));

        ExecutorService executor = Executors.newFixedThreadPool(POOl_SIZE);

        startTime = System.currentTimeMillis();
        cities.forEach(city -> executor.execute(new CityWorker(city, monsters)));

        executor.shutdown();

        try {
            if (!executor.awaitTermination(TIMEOUT, TimeUnit.SECONDS)) {
                log.info("Еще не все задачи завершены");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.info("Поток был прерван");
            Thread.currentThread().interrupt();
            executor.shutdownNow();
        }

        long endTime = System.currentTimeMillis();
        log.info("Время выполнения: {}ms", endTime - startTime);
    }
}
