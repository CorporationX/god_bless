package faang.school.godbless.BJS2_3191;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


// Результаты эксперимента в файле Report.txt
public class Witcher {
    private static final int NUM_THREADS = 16;
    private static final int MULTIPLY_DATA = 1;


    public static void main(String[] args) throws InterruptedException {
        List<Monster> monsters = new ArrayList<>();
        List<City> cities = new ArrayList<>();

        for (int i = 0; i < MULTIPLY_DATA; ++i) {
            monsters.add(new Monster("Griffin", "Velen"));
            monsters.add(new Monster("Basilisk", "Toussaint"));
            monsters.add(new Monster("Cockatrice", "White Orchard"));
            monsters.add(new Monster("Chort", "Skellige"));
            cities.add(new City("Novigrad", new Location(0, 60), 180));
            cities.add(new City("Oxenfurt", new Location(11, 21), 70));
            cities.add(new City("Vizima", new Location(120, 50), 30));
            cities.add(new City("Kaer Morhen", new Location(180, 70), 0));
        }

        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

        long startTime = System.currentTimeMillis();
        cities.forEach(city -> executorService.submit(new CityWorker(city, monsters, cities)));
        executorService.shutdown();
        boolean isFinished = executorService.awaitTermination(60, TimeUnit.SECONDS);
        long endTime = System.currentTimeMillis();
        if (isFinished) {
            System.out.println("Elapsed time: " + (endTime - startTime) + "ms");
        } else {
            System.out.println("Not all tasks finished!");
        }
    }
}
