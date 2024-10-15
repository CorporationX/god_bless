package school.faang.fingerpath;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Witcher {
    private static final int NUM_THREADS = 4;

    public static void main(String[] args) {
        List<City> cities = new ArrayList<>() {{
            add(new City("Novigrad", new Location(0, 60)));
            add(new City("Oxenfurt", new Location(-60, 20)));
            add(new City("Vizima", new Location(120, 50)));
            add(new City("Kaer Morhen", new Location(180, 70)));
        }};
        List<Monster> monsters = new ArrayList<>() {{
            add(new Monster("Griffin", new Location(10, 15)));
            add(new Monster("Basilisk", new Location(235, 121)));
            add(new Monster("Cockatrice", new Location(-124, 36)));
            add(new Monster("Chort", new Location(160, 90)));
        }};

        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);
        long startTime = System.currentTimeMillis();
        for (City city : cities) {
            CityWorker worker = new CityWorker(city, monsters);
            executorService.submit(worker);
        }

        executorService.shutdown();
        try {
            executorService.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            throw new RuntimeException("Ожидание завершения исполнения потоков прервано", e);
        }
        long endTime = System.currentTimeMillis();
        System.out.printf("Все задания выполнены за %s мс" , endTime - startTime);
    }
}
