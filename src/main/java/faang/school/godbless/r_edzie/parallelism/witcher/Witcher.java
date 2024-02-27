package faang.school.godbless.r_edzie.parallelism.witcher;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Witcher {
    private static final int THREAD_AMOUNT = 3;

    public static void main(String[] args) throws InterruptedException {
        List<Monster> monsters = new ArrayList<>();

        monsters.add(new Monster("Griffin", new Location(20, 20)));
        monsters.add(new Monster("Basilisk", new Location(60, 10)));
        monsters.add(new Monster("Cockatrice", new Location(120, 20)));
        monsters.add(new Monster("Chort", new Location(0, 20)));

        List<City> cities = new ArrayList<>();

        cities.add(new City("Novigrad", new Location(0, 60), 180));
        cities.add(new City("Oxenfurt", new Location(60, 0), 70));
        cities.add(new City("Vizima", new Location(120, 50), 30));
        cities.add(new City("Kaer Morhen", new Location(180, 70), 0));

        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_AMOUNT);

        long start = System.currentTimeMillis();

        for (City city : cities) {
            CityWorker cityWorker = new CityWorker(city, monsters);
            executorService.execute(cityWorker);
        }

        executorService.shutdown();
        executorService.awaitTermination(5, TimeUnit.MINUTES);

        long end = System.currentTimeMillis();

        System.out.println(end - start);
    }
}
