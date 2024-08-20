package faang.school.godbless.StickFinger;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Witcher {
    @Getter
    private static final List<Monster> MONSTERS = new ArrayList<>();

    public static void main(String[] args) {
        MONSTERS.add(new Monster("Griffin", 20));
        MONSTERS.add(new Monster("Basilisk", 30));
        MONSTERS.add(new Monster("Cockatrice", 40));
        MONSTERS.add(new Monster("Chort", 50));

        List<City> cities = new ArrayList<>();

        cities.add(new City("Novigrad", 0, 60, 120, 180));
        cities.add(new City("Oxenfurt", 60, 0, 50, 70));
        cities.add(new City("Vizima", 120, 50, 0, 30));
        cities.add(new City("Kaer Morhen", 180, 70, 30, 0));

        List<CityWorker> citiesWorkers = new ArrayList<>();

        cities.forEach(city -> citiesWorkers.add(new CityWorker(city)));

        ExecutorService executorService = Executors.newFixedThreadPool(1);
        for (CityWorker cityWorker : citiesWorkers) {
            executorService.submit(cityWorker);
        }
        executorService.shutdown();

        try {
            executorService.awaitTermination(1, TimeUnit.HOURS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("отработано");
    }
}
