package school.faang.paveTheWay;

import java.util.List;

public class WitcherSingleThread {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        List<City> cities = ListsInitializer.initializeCitiesList();
        List<Monster> monsters = ListsInitializer.initializeMonstersList();
        for (City city : cities) {
            CityWorker worker = new CityWorker(city, monsters);
            worker.run();
        }
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;

        System.out.println("Время выполнения программы: " + executionTime + " миллисекунд");
    }
}
