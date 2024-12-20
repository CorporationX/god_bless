package school.faang.spring3.task_48225;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Witcher {
    private static final int NUM_THREADS = 4;

    public static void main(String[] args) {
        List<City> cities = new ArrayList<>();
        cities.add(new City("Novigrad", new Location(0, 60)));
        cities.add(new City("Oxenfurt", new Location(60, 0)));
        cities.add(new City("Vizima", new Location(120, 50)));
        cities.add(new City("Kaer Morhen", new Location(180, 70)));

        List<Monster> monsters = new ArrayList<>();
        monsters.add(new Monster("Griffin", new Location(10, 15)));
        monsters.add(new Monster("Basilisk", new Location(235, 121)));
        monsters.add(new Monster("Cockatrice", new Location(-124, 36)));
        monsters.add(new Monster("Chort", new Location(374, -237)));

        List<Future<Double>> futures = new ArrayList<>();
        ExecutorService service = Executors.newFixedThreadPool(NUM_THREADS);
        for (City city : cities) {
            futures.add(service.submit(new CityHandler(city, monsters)));
        }
        double min = Double.MAX_VALUE;
        for (Future<Double> future : futures) { // чисто чтоб достаться результатов всех
            // на самом деле это не оч решение но она позволяет нам дождаться результатов всех потоков
            // так как мы блокируем поток main в методе get
            try {
                Double o = future.get();
                if (o < min) {
                    min = o;
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("The nearest is " + min);
        service.shutdown();


    }
}
