package faang.school.godbless.sprint4.multithreading_parallelism_thread.task10;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Witcher {

    public static void main(String[] args) throws InterruptedException {
        List<City> cities = new ArrayList<>();
        City Novigrad = new City("Novigrad", new Location(0, 60));
        City Oxenfurt = new City("Oxenfurt", new Location(60, 0));
        City Vizima = new City("Vizima", new Location(120, 50));
        City KaerMorhen = new City("Kaer Morhen", new Location(180, 70));
        cities.add(Novigrad);
        cities.add(Oxenfurt);
        cities.add(Vizima);
        cities.add(KaerMorhen);

        List<Monster> monsters = new ArrayList<>();

        monsters.add(new Monster("Griffin", "Velen"));
        monsters.add(new Monster("Basilisk", "Toussaint"));
        monsters.add(new Monster("Cockatrice", "White Orchard"));
        monsters.add(new Monster("Chort", "Skellige"));

        int NUM_THREADS = 3;

        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        long start = System.currentTimeMillis();
        for (City city : cities) {
            executor.execute(new CityWorker(monsters, city));
        }

        executor.shutdown();

        while (!executor.awaitTermination(5, TimeUnit.MILLISECONDS)){}

        long end = System.currentTimeMillis();

        System.out.println("Время работы программы: " + (end - start));
    }
}
