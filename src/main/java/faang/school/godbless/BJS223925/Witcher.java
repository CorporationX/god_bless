package faang.school.godbless.BJS223925;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Witcher {
    public static void main(String[] args) {
        List<Monster> monsters = new ArrayList<>();
        monsters.add(new Monster("Griffin", new Location(0, 50)));
        monsters.add(new Monster("Basilisk", new Location(60, 0)));
        monsters.add(new Monster("Cockatrice", new Location(120, 100)));
        monsters.add(new Monster("Chort", new Location(180, 70)));

        List<City> cities = new ArrayList<>();
        cities.add(new City("Novigrad", new Location(0, 60), new Location(120, 180)));
        cities.add(new City("Oxenfurt", new Location(60, 0), new Location(50, 70)));
        cities.add(new City("Vizima", new Location(120, 50), new Location(0, 30)));
        cities.add(new City("Kaer Morhen", new Location(180, 70), new Location(30, 0)));

        final int NUM_THREADS = 2;
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

        long startTime = System.currentTimeMillis();

        for (City city : cities) {
            executorService.submit(new CityWorker(city, monsters));
        }

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(1, TimeUnit.HOURS)) {
                System.err.println("Не удалось завершить все задачи за отведенное время");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            System.err.println("Поток прерван");
            executorService.shutdownNow();
            // чат подсказал. не совсем понимаю зачем нужен
            Thread.currentThread().interrupt();
        }
        
        long endTime = System.currentTimeMillis();
        System.out.println("Общее время выполнения программы: " + (endTime - startTime) + " миллисекунд");
    }
}
