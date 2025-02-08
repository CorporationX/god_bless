package school.faang.witcher.magic.map;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Witcher {

    public static void main(String[] args) {
        final Location witcher = new Location(0, 0);
        final int CITIES_COUNT = 100000;
        final int MONSTERS_COUNT = 10000;

        List<City> cities = new ArrayList<>(CITIES_COUNT);
        List<Monster> monsters = new ArrayList<>(MONSTERS_COUNT);

        for (int number = 0; number < CITIES_COUNT; number++) {
            String name = "City " + (number+1);
            cities.add(new City(name, Location.set()));
        }

        for (int number = 0; number < MONSTERS_COUNT; number++) {
            String name = "Monster " + (number+1);
            monsters.add(new Monster(name, Location.set()));

        }

        singleThreadTask(witcher, cities, monsters);
        multiThreadTask(4, witcher, cities, monsters);
        multiThreadTask(8, witcher, cities, monsters);
    }

    static void singleThreadTask(Location witcher, List<City> cities, List<Monster> monsters) {
        long startTime = System.currentTimeMillis();

        cities.forEach((city) -> {
            CityWorker worker = new CityWorker(city, monsters, witcher);
            worker.run();
        });
        System.out.println("The shortest distance is " + CityWorker.bestDistance);

        long endTime = System.currentTimeMillis();
        System.out.printf("Elapsed time when using single thread: %dms\n", endTime - startTime);
    }

    static void multiThreadTask(int nThreads, Location witcher, List<City> cities, List<Monster> monsters) {
        long startTime = System.currentTimeMillis();

        ExecutorService executor = Executors.newFixedThreadPool(nThreads);
        cities.forEach((city) -> {
            CityWorker worker = new CityWorker(city, monsters, witcher);
            executor.submit(worker);
        });
        executor.shutdown();

        System.out.println("The shortest distance is " + CityWorker.bestDistance);

        long endTime = System.currentTimeMillis();
        System.out.printf("Elapsed time when using %d threads: %dms\n", nThreads, endTime - startTime);
    }
}
