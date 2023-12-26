package Witcher;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Witcher {

    public static void main(String[] args) throws InterruptedException {

        int NUM_TREADS = 4;

        List<City> cities = new ArrayList<>();

        cities.add(new City("Novigrad", new Location(0, 60), 180));
        cities.add(new City("Oxenfurt", new Location(60, 0), 70));
        cities.add(new City("Vizima", new Location(120, 50), 30));
        cities.add(new City("Kaer Morhen", new Location(180, 70), 0));


        ExecutorService executorService = Executors.newFixedThreadPool(NUM_TREADS);

        long startTimer = System.currentTimeMillis();

        for (City city : cities) {
            CityWorker cityWorker = new CityWorker(city);
            executorService.submit(cityWorker);
        }
        executorService.shutdown();

        while (!executorService.awaitTermination(3, TimeUnit.SECONDS)) {
        }
        long endTimer = System.currentTimeMillis();

        System.out.println(endTimer - startTimer);
    }
}
