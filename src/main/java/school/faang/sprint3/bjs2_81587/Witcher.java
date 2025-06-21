package school.faang.sprint3.bjs2_81587;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Witcher {
    private static final int NUM_THREADS = 4;

    public static void main(String[] args) throws InterruptedException {
        // Список городов и монстров (пример заполнения):
        List<City> cities = List.of(
                new City("Novigrad", new Location(0, 60)),
                new City("Oxenfurt", new Location(60, 0)),
                new City("Vizima", new Location(120, 50)),
                new City("Kaer Morhen", new Location(180, 70))
        );

        List<Monster> monsters = List.of(
                new Monster("Griffin", new Location(10, 15)),
                new Monster("Basilisk", new Location(235, 121)),
                new Monster("Cockatrice", new Location(-124, 36)),
                new Monster("Chort", new Location(374, -237))
        );

        // Создаем пул потоков
        ExecutorService executorService = Executors.newFixedThreadPool(NUM_THREADS);

        // Добавляем задачи в пул потоков
        for (City city : cities) {
            CityWorker worker = new CityWorker(city, monsters);
            executorService.submit(worker);
        }

        // Завершаем пул потоков и ждем завершения всех задач
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(1, TimeUnit.MINUTES)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            executorService.shutdownNow();
        }

        System.out.println("Все задания выполнены.");
    }
}
