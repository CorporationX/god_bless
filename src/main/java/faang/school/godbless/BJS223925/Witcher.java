package faang.school.godbless.BJS223925;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Witcher {
    public static void main(String[] args) {
        List<Monster> monsters = new ArrayList<>();
        monsters.add(new Monster("Griffin", 0, 50));
        monsters.add(new Monster("Basilisk", 60, 0));
        monsters.add(new Monster("Cockatrice", 120, 100));
        monsters.add(new Monster("Chort", 180, 70));

        List<City> cities = new ArrayList<>();
        cities.add(new City("Novigrad", 0, 60, 120, 180));
        cities.add(new City("Oxenfurt", 60, 0, 50, 70));
        cities.add(new City("Vizima", 120, 50, 0, 30));
        cities.add(new City("Kaer Morhen", 180, 70, 30, 0));

        final int NUM_THREADS = 2;
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

        long startTime = System.currentTimeMillis();

        for (City city : cities) {
            executorService.submit(new CityWorker(city, monsters));
        }

        executorService.shutdown();
        try {
            executorService.awaitTermination(1, TimeUnit.HOURS);
        } catch (InterruptedException e) {
//            e.printStackTrace();
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Общее время выполнения программы: " + (endTime - startTime) + " миллисекунд");
    }
}
