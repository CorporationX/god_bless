package faang.school.godbless.RoadWithFinger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Witcher {
    public static final int NUM_THREADS = 1;        //в один поток получается быстрее

    public static void main(String[] args) {

        List<Monster> monsters = new ArrayList<>();

        monsters.add(new Monster("Griffin", "Velen"));
        monsters.add(new Monster("Basilisk", "Toussaint"));
        monsters.add(new Monster("Cockatrice", "White Orchard"));
        monsters.add(new Monster("Chort", "Skellige"));


        List<City> cities = new ArrayList<>();

        cities.add(new City("Novigrad", new Location(0, 60), 180));
        cities.add(new City("Oxenfurt", new Location(60, 0), 70));
        cities.add(new City("Vizima", new Location(120, 50), 30));
        cities.add(new City("Kaer Morhen", new Location(180, 70), 0));


        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);
        long startTime = System.currentTimeMillis();
        for (City city : cities) {
            executorService.execute(new CityWorker(city, monsters));
            // очень хочется здесь заблокировать создание новых потоков до выполнения текущего

        }
        executorService.shutdown();

        try {
            executorService.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Elapsed time: " + (endTime - startTime) + "ms");
    }
}
