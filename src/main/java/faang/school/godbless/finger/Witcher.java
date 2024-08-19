package faang.school.godbless.finger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Witcher {

    private static final int THREAD_COUNT = 5;

    public static void main(String[] args) throws InterruptedException {
        List<Monster> monsters = new ArrayList<>();

        monsters.add(new Monster("Griffin", new Location(10, 20)));
        monsters.add(new Monster("Basilisk", new Location(30, 40)));
        monsters.add(new Monster("Cockatrice", new Location(50, 60)));
        monsters.add(new Monster("Chort", new Location(70, 80)));

        List<City> cities = new ArrayList<>();

        cities.add(new City("Novigrad", new Location(0, 60), 180));
        cities.add(new City("Oxenfurt", new Location(60, 0), 70));
        cities.add(new City("Vizima", new Location(120, 50), 30));
        cities.add(new City("Kaer Morhen", new Location(180, 70), 0));

        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_COUNT);

        long start = System.currentTimeMillis();

        for (City city : cities) {
            executorService.submit(new CityWorker(city, monsters));
        }

        executorService.shutdown();
        while (!executorService.awaitTermination(3, TimeUnit.SECONDS)) {}

        long finish = System.currentTimeMillis();

        System.out.println("Время работы =" + (finish - start));
    }
}
