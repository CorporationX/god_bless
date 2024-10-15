package school.BJS2_36302;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Witcher {

    public static void main(String[] args) throws InterruptedException {

        final int SIZE_OF_THREADS = 3;

        long startTime = System.nanoTime();
        Monster monster1 = new Monster("Грифон", new Location(15, 20));
        Monster monster2 = new Monster("Леший", new Location(5, 10));
        Monster monster3 = new Monster("Медуза", new Location(25, 25));
        Monster monster4 = new Monster("Водяной", new Location(35, 45));
        Monster monster5 = new Monster("Великан", new Location(50, 5));
        Monster monster6 = new Monster("Бес", new Location(40, 30));
        Monster monster7 = new Monster("Утопец", new Location(55, 60));
        Monster monster8 = new Monster("Кикимора", new Location(65, 20));
        Monster monster9 = new Monster("Призрак", new Location(70, 80));
        Monster monster10 = new Monster("Эндриага", new Location(85, 75));
        List<Monster> monstersByCity1 = new ArrayList<>(Arrays.asList(monster1, monster2, monster3, monster4));
        List<Monster> monstersByCity2 = new ArrayList<>(Arrays.asList(monster5, monster6, monster7, monster8));
        List<Monster> monstersByCity3 = new ArrayList<>(Arrays.asList(monster9, monster10, monster2, monster3));
        City city1 = new City("Новиград", new Location(43, 132));
        City city2 = new City("Оксенфурт", new Location(55, 73));
        City city3 = new City("Вижима", new Location(41, 44));
        ExecutorService executorService = Executors.newFixedThreadPool(SIZE_OF_THREADS);
        executorService.execute(new CityWorker(city1, monstersByCity1));
        executorService.execute(new CityWorker(city2, monstersByCity2));
        executorService.execute(new CityWorker(city3, monstersByCity3));

        executorService.shutdown();
        executorService.awaitTermination(20, TimeUnit.SECONDS);
//        CityWorker cityWorker1 = new CityWorker(city1,monstersByCity1);
//        CityWorker cityWorker2 = new CityWorker(city2,monstersByCity2);
//        CityWorker cityWorker3 = new CityWorker(city3, monstersByCity3);
//        cityWorker1.run();
//        cityWorker2.run();
//        cityWorker3.run();

        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        double seconds = (double) duration / 1_000_000_000.0;
        System.out.println("Затраченное время на выполенение программы: " + seconds);
        //Итог при быстрых вчислениях разница не заметна. При выставлении задержки в секунду в методе run,
        //скрипт без потоков отрабатывает за 3 секунды, а с потоками в 1 суммарную.

    }
}