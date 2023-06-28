package faang.school.godbless.sprint4.multithreading_parallelism_thread.task10;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Witcher {

    public static void main(String[] args) throws InterruptedException {
        List<City> cities = new ArrayList<>();
        City Novigrad = new City("Novigrad", 0);
        City Oxenfurt = new City("Oxenfurt", 60);
        City Vizima = new City("Vizima", 120);
        City KaerMorhen = new City("Kaer Morhen", 180);
        cities.add(Novigrad);
        cities.add(Oxenfurt);
        cities.add(Vizima);
        cities.add(KaerMorhen);

        List<Monster> monsters = new ArrayList<>();

        monsters.add(new Monster("Griffin", 0));
        monsters.add(new Monster("Basilisk", 60));
        monsters.add(new Monster("Cockatrice", 120));
        monsters.add(new Monster("Chort", 180));

        int NUM_THREADS = 1;

        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        long start = System.currentTimeMillis();
        for (City city : cities) {
            executor.execute(new CityWorker(monsters, city));
        }

        executor.shutdown();
        long end = System.currentTimeMillis();

        while (!executor.awaitTermination(5, TimeUnit.MILLISECONDS)){}

        System.out.println("Время работы программы: " + (end - start));
    }
}
