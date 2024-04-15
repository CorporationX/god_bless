package faang.school.godbless.FingerPath;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Witcher {
    private static final int NUM_THREADS = 4;

    public static void main(String[] args) throws InterruptedException {
        List<Monster> monsters = getMonsters();
        List<City> cities = getCities();
        ExecutorService pool = Executors.newFixedThreadPool(NUM_THREADS);

        long startTime = System.currentTimeMillis();
        for (City city : cities) {
            pool.execute(new CityWorker(city, monsters));
        }
        pool.shutdown();
        while (!pool.awaitTermination(3, TimeUnit.SECONDS));
        long endTime = System.currentTimeMillis();

        System.out.println("Total operations time -> " + (endTime - startTime) + "ms");
    }

    private static List<City> getCities() {
        List<City> cities = new ArrayList<>();
        cities.add(new City(CityName.NOVIGRAD, new Location(0, 60), 180));
        cities.add(new City(CityName.VELEN, new Location(60, 0), 70));
        cities.add(new City(CityName.VIZIMA, new Location(120, 50), 30));
        cities.add(new City(CityName.TUSSENT, new Location(180, 70), 0));
        return cities;
    }

    private static List<Monster> getMonsters() {
        List<Monster> monsters = new ArrayList<>();
        monsters.add(new Monster("Griffin", new Location(20, 60)));
        monsters.add(new Monster("Basilisk", new Location(60, 20)));
        monsters.add(new Monster("Cockatrice", new Location(120, 100)));
        monsters.add(new Monster("Chort", new Location(180, 100)));
        return monsters;
    }
}
