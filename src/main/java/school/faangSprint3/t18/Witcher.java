package school.faangSprint3.t18;

import java.util.*;
import java.util.concurrent.*;

public class Witcher {
    public static void main(String[] args) {
        List<City> cities = new ArrayList<>();
        cities.add(new City("Новиград", new Location(0, 60)));
        cities.add(new City("Оксенфурт", new Location(60, 0)));
        cities.add(new City("Визима", new Location(120, 50)));
        cities.add(new City("Каэр Морхен", new Location(180, 70)));
        cities.add(new City("Венгерберг", new Location(90, 120)));
        cities.add(new City("Ринда", new Location(-50, 80)));
        cities.add(new City("Горс Велен", new Location(30, -40)));
        cities.add(new City("Марибор", new Location(-80, -60)));

        List<Monster> monsters = new ArrayList<>();
        monsters.add(new Monster("Грифон", new Location(10, 15)));
        monsters.add(new Monster("Василиск", new Location(235, 121)));
        monsters.add(new Monster("Кокатрикс", new Location(-124, 36)));
        monsters.add(new Monster("Чёрт", new Location(374, -237)));
        monsters.add(new Monster("Стрыга", new Location(55, 89)));
        monsters.add(new Monster("Накер", new Location(-45, -120)));
        monsters.add(new Monster("Гуль", new Location(150, -80)));
        monsters.add(new Monster("Виверна", new Location(-200, 180)));

        runSingleThread(cities, monsters);
        runWithThreads(cities, monsters, 2);
        runWithThreads(cities, monsters, 4);
        runWithThreads(cities, monsters, 8);
    }
    public static void runWithThreads(List<City> cities, List<Monster> monsters, int numThreads) {
        System.out.println("\nЗапуск с " + numThreads + " потоками:");
        long startTime = System.currentTimeMillis();

        ExecutorService executorService = Executors.newFixedThreadPool(numThreads);

        for (City city : cities) {
            CityWorker worker = new CityWorker(city, monsters);
            executorService.submit(worker);
        }

        executorService.shutdown();
        try {
            executorService.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            System.out.println("Выполнение прервано");
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Время выполнения: " + (endTime - startTime) + "мс");
    }

    public static void runSingleThread(List<City> cities, List<Monster> monsters) {
        System.out.println("\nЗапуск в однопоточном режиме:");
        long startTime = System.currentTimeMillis();

        for (City city : cities) {
            CityWorker worker = new CityWorker(city, monsters);
            worker.run();
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Время выполнения: " + (endTime - startTime) + "мс");
    }
}