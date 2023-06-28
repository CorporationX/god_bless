package faang.school.godbless.PavingTheWayWithYourFinger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Witcher {
    public static void main(String[] args) {
        List<Monster> monsters = new ArrayList<>();
        monsters.add(new Monster("Griffin", "Velen"));
        monsters.add(new Monster("Basilisk", "Toussaint"));
        monsters.add(new Monster("Cockatrice", "White Orchard"));
        monsters.add(new Monster("Chort", "Skellige"));
        List<City> cities = new ArrayList<>();
        cities.add(new City("Novigrad", 10, 0, 60, 120, 180));
        cities.add(new City("Oxenfurt", 20, 60, 0, 50, 70));
        cities.add(new City("Vizima", 30, 120, 50, 0, 30));
        cities.add(new City("Kaer Morhen", 40, 180, 70, 30, 0));
        System.out.println("Multiple Threads");
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        for (int i = 0; i < 4; i++) {
            CityWorker cityWorker = new CityWorker(monsters.get(i), cities.get(i));
            executorService.execute(cityWorker);
        }
        executorService.shutdown();
        System.out.println("Single thread");
    }
}
