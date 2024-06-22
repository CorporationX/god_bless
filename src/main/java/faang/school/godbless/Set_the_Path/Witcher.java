package faang.school.godbless.Set_the_Path;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Witcher {

    private static final List<Monster> MONSTERS = new ArrayList<>();
    private static final List<City> CITIES = new ArrayList<>();
    private static final int NUM_THREADS = 4;
    private static final City NOVIGRAD = new City("Novigrad", new Location(0, 60),  180);
    private static final City OXENFURT = new City("Oxenfurt", new Location(60, 0), 70);
    private static final City VIZIMA = new City("Vizima", new Location(120, 50), 30);
    private static final City KAER = new City("Kaer Morhen", new Location(180, 70), 0);

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);
        for (City city: CITIES) {
            executorService.submit(new CityWorker(city, MONSTERS));
        }

    }

    static {

        MONSTERS.add(new Monster("Griffin", "Velen"));
        MONSTERS.add(new Monster("Basilisk", "Toussaint"));
        MONSTERS.add(new Monster("Cockatrice", "White Orchard"));
        MONSTERS.add(new Monster("Chort", "Skellige"));

        CITIES.add(NOVIGRAD);
        CITIES.add(OXENFURT);
        CITIES.add(VIZIMA);
        CITIES.add(KAER);

    }

}
