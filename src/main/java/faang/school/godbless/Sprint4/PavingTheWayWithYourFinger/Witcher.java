package faang.school.godbless.Sprint4.PavingTheWayWithYourFinger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Witcher {
    public static void main(String[] args) {
        for (int NUM_THREADS=1;NUM_THREADS<10;NUM_THREADS++) {
            ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

            //название локации монстра ничего не говорит без координат
            //(исключение когда есть карта где ключ название, значение - локация
            List<Monster> monsters = new ArrayList<>();
            monsters.add(new Monster("Griffin", new Location(0,0)));
            monsters.add(new Monster("Basilisk", new Location(100,10)));
            monsters.add(new Monster("Cockatrice", new Location(50,200)));
            monsters.add(new Monster("Chort", new Location(20,70)));

            //не понял зачем хранить растояние,если объект дивжется и его придется менть для каждого объекта
            //проше посчитать по коорлинатам
            List<City> cities = new ArrayList<>();
            cities.add(new City("Novigrad", new Location(0, 60)));
            cities.add(new City("Oxenfurt", new Location(60, 0)));
            cities.add(new City("Vizima", new Location(120, 50)));
            cities.add(new City("Kaer Morhen", new Location(180, 70)));

            long startTime = System.currentTimeMillis();
            for (City city : cities) {
                executor.execute(new CityWorker(city, monsters));
            }

            executor.shutdown();
            //Возможно где-то ошибка, результаты всегда разные
            System.out.println("Количество потоков - " + NUM_THREADS + " Time taken: " + (System.currentTimeMillis() - startTime));
        }
    }
}
