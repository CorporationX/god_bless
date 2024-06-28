package faang.school.godbless.paveTheWay;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Witcher {
    private static final int NUM_THREADS = 4;

    public static void main(String[] args) {
        List<Monster> monsters = new ArrayList<>();
        monsters.add(new Monster("Грифон", new Location(10, 15)));
        monsters.add(new Monster("Базилиск", new Location(20, 25)));
        monsters.add(new Monster("Кокатрис", new Location(30, 35)));
        monsters.add(new Monster("Хорт", new Location(40, 45)));

        List<City> cities = new ArrayList<>();
        cities.add(new City("Новиград", new Location(0, 60), 60));
        cities.add(new City("Оксенфурт", new Location(60, 0), 60));
        cities.add(new City("Визима", new Location(120, 50), 130));
        cities.add(new City("Каэр Морхен", new Location(180, 70), 200));

        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

        long startTime = System.currentTimeMillis();

        for (City city : cities) {
            CityWorker worker = new CityWorker(city, monsters);
            executorService.submit(worker);
        }

        executorService.shutdown();

        try {
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            System.err.println("Завершение работы ExecutorService было прервано.");
        }

        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;

        System.out.println("Общее время выполнения программы: " + totalTime + " мс");
    }
}

