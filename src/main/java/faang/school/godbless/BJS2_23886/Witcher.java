package faang.school.godbless.BJS2_23886;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Witcher {

    public static void main(String[] args) throws InterruptedException {

        List<Monster> monsters = new ArrayList<>();

        monsters.add(new Monster("Griffin", "Velen"));
        monsters.add(new Monster("Basilisk", "Toussaint"));
        monsters.add(new Monster("Cockatrice", "White Orchard"));
        monsters.add(new Monster("Chort", "Skellige"));

        List<City> cities = new ArrayList<>();

        cities.add(new City("Novigrad", new Location(0, 60),  180));
        cities.add(new City("Oxenfurt", new Location(60, 0), 70));
        cities.add(new City("Vizima", new Location(120, 50), 30));
        cities.add(new City("Kaer Morhen", new Location(180, 70), 0));

        int NUM_THREADS = 4;
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

        long start = System.currentTimeMillis();

        for(City city : cities) {
            executorService.execute(new CityWorker(city, monsters));
        }
        executorService.awaitTermination(5L, TimeUnit.SECONDS);
        executorService.shutdown();

        System.out.println("Time to complete program: " + (double) (System.currentTimeMillis() - start)/1000);
    }
}
