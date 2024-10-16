package school.faang.task3111.creature;

import school.faang.task3111.city.City;
import school.faang.task3111.city.Location;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Witcher {
    public static void main(String[] args) {
        City firstCity = new City("Вызима", new Location(35, 40));
        City secondCity = new City("Ринда", new Location(123, 90));

        List<Monster> monstersNearFirstCity = new ArrayList<>();
        List<Monster> monstersNearSecondCity = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 3; i++) {
            monstersNearFirstCity.add(new Monster("Monstre№" + i, new Location(random.nextInt(180), random.nextInt(180))));
            monstersNearSecondCity.add(new Monster("Monstre№" + i, new Location(random.nextInt(180), random.nextInt(180))));
        }

        CityWorker firstCityWorker = new CityWorker(firstCity, monstersNearFirstCity);
        CityWorker secondCityWorker = new CityWorker(secondCity, monstersNearSecondCity);

        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.submit(firstCityWorker);
        executor.submit(secondCityWorker);

        executor.shutdown();
        try {
            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                executor.shutdownNow();
                System.out.println("Something went wrong, shut down task now");
            }
        } catch (InterruptedException e) {
            System.out.println("Something went wrong");
            throw new RuntimeException(e.getMessage());
        }
        System.out.println("Оптимальные расстояния найдены!");
    }
}
