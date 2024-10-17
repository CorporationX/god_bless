package school.faang.pavethewaywithyourfinger.main;

import school.faang.pavethewaywithyourfinger.maincode.City;
import school.faang.pavethewaywithyourfinger.maincode.CityWorker;
import school.faang.pavethewaywithyourfinger.maincode.Location;
import school.faang.pavethewaywithyourfinger.maincode.Monster;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Witcher {
    private static final int THREAD_COUNT = 5;
    public static void main(String[] args) {
        Monster monster1 = new Monster("monster1", new Location(3, 3));
        Monster monster2 = new Monster("monster2", new Location(2, 1));
        Monster monster3 = new Monster("monster3", new Location(2, 5));
        Monster monster4 = new Monster("monster4", new Location(6, 6));
        Monster monster5 = new Monster("monster5", new Location(2, 7));
        Monster monster6 = new Monster("monster6", new Location(2, 4));
        Monster monster7 = new Monster("monster7", new Location(5, 3));
        Monster monster8 = new Monster("monster8", new Location(3, 4));
        Monster monster9 = new Monster("monster9", new Location(5, 6));
        List<Monster> monsters = Arrays.asList(monster1, monster2, monster3, monster4, monster5, monster6,
                monster7, monster8, monster9);

        City city1 = new City("city1", new Location(4, 4));
        City city2 = new City("city2", new Location(5, 5));
        City city3 = new City("city3", new Location(2, 2));
        City city4 = new City("city4", new Location(7, 8));
        City city5 = new City("city5", new Location(8, 7));
        List<City> cities = Arrays.asList(city1, city2, city3, city4, city5);

        ExecutorService service = Executors.newFixedThreadPool(THREAD_COUNT);

        Long starTime = System.currentTimeMillis();

        for (City city : cities) {
            CityWorker cityWorker = new CityWorker(city, monsters);
            service.submit(() -> System.out.println(cityWorker));
        }

        service.shutdown();
        try{
            if (!service.awaitTermination(2, TimeUnit.MINUTES)) {
                service.shutdownNow();
            }
        } catch (InterruptedException e) {
            service.shutdownNow();
        }

        long endTime = System.currentTimeMillis();
        System.out.println("Время выполнения программы " + (endTime - starTime) + "ms");
    }
}
