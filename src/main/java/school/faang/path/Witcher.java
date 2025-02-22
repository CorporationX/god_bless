package school.faang.path;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Witcher {
    public static void main(String[] args) {
        List<String> cityNames = List.of("Tokyo", "Delhi", "Shanghai", "São Paulo", "Mexico City",
                "Cairo", "Mumbai", "Beijing", "Dhaka", "Osaka",
                "New York", "Karachi", "Buenos Aires", "Istanbul", "Chongqing",
                "Kolkata", "Lagos", "Kinshasa", "Manila", "Rio de Janeiro");
        List<String> monsterNames = List.of(
                "Leshen", "Griffin", "Drowner", "Alghoul", "Basilisk",
                "Fiend", "Striga", "Ekhidna", "Katakan", "Bruxa"
        );

        List<City> cities = new ArrayList<>();
        for (String cityName : cityNames) {
            cities.add(new City(cityName,
                    new Location(new Random().nextInt(351) + 50,
                            new Random().nextInt(351) + 50)));
        }

        List<Monster> monsters = new ArrayList<>();
        for (String monsterName : monsterNames) {
            monsters.add(new Monster(monsterName,
                    new Location(new Random().nextInt(351) + 50,
                            new Random().nextInt(351) + 50)));
        }

        List<CityWorker> cityWorkers = new ArrayList<>();
        for (City city : cities) {
            cityWorkers.add(new CityWorker(city, monsters));
        }

        int numThreads = 10;
        ExecutorService executorService = Executors.newFixedThreadPool(numThreads);
        final long startTime = System.currentTimeMillis();
        for (CityWorker cityWorker : cityWorkers) {
            executorService.submit(cityWorker);
        }
        executorService.shutdown();
        try {
            if (executorService.awaitTermination(5, TimeUnit.SECONDS)) {
                System.out.println("All paths are calculated");
            } else {
                System.out.println("Timeout expired");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Total time taken: " + (endTime - startTime) + "ms");
    }


}
