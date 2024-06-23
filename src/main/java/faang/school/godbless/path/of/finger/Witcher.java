package faang.school.godbless.path.of.finger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Witcher {
    private static final int NUM_THREADS = 4;

    public static void main(String[] args) throws Exception {
        List<Monster> monsters = new ArrayList<>();
        monsters.add(new Monster("Griffin", new Location(0, 70)));
        monsters.add(new Monster("Basilisk", new Location(60, 60)));
        monsters.add(new Monster("Cockatrice", new Location(120, 40)));
        monsters.add(new Monster("Chort", new Location(180, 90)));

        List<City> cities = new ArrayList<>();
        cities.add(new City("Novigrad", new Location(0, 60), 180));
        cities.add(new City("Oxenfurt", new Location(60, 0), 70));
        cities.add(new City("Vizima", new Location(120, 50), 30));
        cities.add(new City("Kaer Morhen", new Location(180, 70), 0));

        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);
        List<CityWorker> workers = new ArrayList<>();

        long startTime = System.currentTimeMillis();

        for (City city : cities) {
            CityWorker worker = new CityWorker(city, monsters);
            workers.add(worker);
            executorService.submit(worker);
        }

        executorService.shutdown();
        executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);

        long totalTime = 0;
        for (CityWorker worker : workers) {
            totalTime += worker.getResult();
        }

        long endTime = System.currentTimeMillis();

        System.out.println("Общее время выполнения программы: " + (endTime - startTime) + " мс");
        System.out.println("Общее время путешествий и убийств: " + totalTime + " мс");
    }
}
