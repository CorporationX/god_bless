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

        cities.add(new City("Novigrad", 0,  List.of(60, 120, 180)));
        cities.add(new City("Oxenfurt", 60, List.of(60, 120, 180)));
        cities.add(new City("Vizima", 120, List.of(60, 120, 180)));
        cities.add(new City("Kaer Morhen", 180, List.of(60, 120, 180)));

        List<CityWorker> citiesWorkers = new ArrayList<>();

        cities.forEach(city -> citiesWorkers.add(new CityWorker(city)));

        ExecutorService executorService = Executors.newFixedThreadPool(1);
        for (CityWorker cityWorker : citiesWorkers) {
            executorService.execute(cityWorker);
        }

        executorService.shutdown();
        try {
            if (executorService.awaitTermination(1, TimeUnit.HOURS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            System.out.println("NOOOOOOOO INTERRUPTED");
            throw new RuntimeException(e);
        }
        System.out.println("отработано");
    }
}
