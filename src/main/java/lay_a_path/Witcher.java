package lay_a_path;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Witcher {
    private final static int NUM_THREADS = 5;

    public static void main(String[] args) throws InterruptedException {
        List<Monster> monsters = new ArrayList<>();

        monsters.add(new Monster("Griffin", new Location(10, 15)));
        monsters.add(new Monster("Basilisk", new Location(235, 121)));
        monsters.add(new Monster("Cockatrice", new Location(-124, 36)));
        monsters.add(new Monster("Chort", new Location(374, -237)));
        monsters.add(new Monster("Griffin1", new Location(100, 150)));
        monsters.add(new Monster("Basilisk2", new Location(-235, -121)));
        monsters.add(new Monster("Cockatrice3", new Location(-124, 136)));
        monsters.add(new Monster("Chort4", new Location(-374, -237)));
        monsters.add(new Monster("Griffin5", new Location(110, 15)));
        monsters.add(new Monster("Basilisk6", new Location(2235, 121)));
        monsters.add(new Monster("Cockatrice7", new Location(124, -36)));
        monsters.add(new Monster("Chort8", new Location(374, 237)));

        List<City> cities = new ArrayList<>();

        cities.add(new City("Novigrad", new Location(0, 60)));
        cities.add(new City("Oxenfurt", new Location(60, 0)));
        cities.add(new City("Vizima", new Location(120, 50)));
        cities.add(new City("Kaer Morhen", new Location(180, 70)));
        cities.add(new City("Novigrad1", new Location(0, 23)));
        cities.add(new City("Oxenfurt2", new Location(512, 0)));
        cities.add(new City("Vizima3", new Location(1653, 550)));
        cities.add(new City("Kaer Morhen4", new Location(-125, -123)));
        cities.add(new City("Novigrad5", new Location(10, 65)));
        cities.add(new City("Oxenfurt6", new Location(52, 52)));
        cities.add(new City("Vizima7", new Location(50, 70)));
        cities.add(new City("Kaer Morhen8", new Location(-250, 70)));

        long start = System.currentTimeMillis();

        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

        cities.forEach(city -> executorService.execute(new CityWorker(city, monsters)));

        executorService.shutdown();

        if (executorService.awaitTermination(5, TimeUnit.SECONDS)) {
            long end = System.currentTimeMillis();
            System.out.println("Время работы программы: " + (end - start) + "ms");
        } else {
            System.out.println("Время ожидания выполнения программы превышено");
        }

        /*
        * я изменял число потоков в тредпуле, но время выполнения программы не сильно меняется,
        * я добавил еще городов и монстров, но видимо на таком небольшом объеме данных тяжело увидеть все
        * преимущества многопоточного программирования
        * */

    }


}
