package faang.school.godbless.parallelismAndThread.pavingTheWayByFinger;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Witcher {
    private static final int NUMBER_OF_THREADS = 2;

    public static void main(String[] args) {
        List<Monster> monsters = new ArrayList<>();

        monsters.add(new Monster("Griffin", "Oxenfurt"));
        monsters.add(new Monster("Basilisk", "Vizima"));
        monsters.add(new Monster("Cockatrice", "Kaer Morhen"));
        monsters.add(new Monster("Chort", "Kaer Morhen"));
        monsters.add(new Monster("123", "Kaer Morhen"));
        monsters.add(new Monster("657", "Vizima"));

        List<City> cities = new ArrayList<>();

        cities.add(new City("Novigrad", Map.of("Oxenfurt", 60, "Vizima", 120, "Kaer Morhen", 180)));
        cities.add(new City("Oxenfurt", Map.of("Novigrad", 60, "Vizima", 50, "Kaer Morhen", 70)));
        cities.add(new City("Vizima", Map.of("Novigrad", 120, "Oxenfurt", 50, "Kaer Morhen", 30)));
        cities.add(new City("Kaer Morhen", Map.of("Novigrad", 180, "Oxenfurt", 70, "Vizima", 30)));

        ExecutorService executorService = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
        List<CityWorker> cityWorkerList = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите индекс текущего города: ");
        int index = scanner.nextInt();
        if (cities.size() <= index) {
            System.out.println("Город вне зоны досягаемости!");
            return;
        }

        City currentCity = cities.get(index);

        long startTime = System.currentTimeMillis();

        for (Monster monster : monsters) {
            CityWorker cityWorker = new CityWorker(currentCity, monster);
            cityWorkerList.add(cityWorker);
            executorService.submit(cityWorker);
        }

        executorService.shutdown();

        try {
            if (executorService.awaitTermination(1, TimeUnit.MINUTES)) {
                int minTime = Integer.MAX_VALUE;
                Monster closestMonster = null;
                for (CityWorker cityWorker : cityWorkerList) {
                    if (cityWorker.getTotalTime() < minTime) {
                        minTime = cityWorker.getTotalTime();
                        closestMonster = cityWorker.getMonster();
                    }
                }

                if (closestMonster == null)
                    return;

                System.out.println("Ближайший монстр: " + closestMonster + ". Общее время: " + minTime);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        long endTime = System.currentTimeMillis();

        System.out.println("Потраченное время: " + (endTime - startTime));
    }
}
