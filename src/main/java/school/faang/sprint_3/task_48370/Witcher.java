package school.faang.sprint_3.task_48370;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Witcher {
    public static final int THREADS_POOL_SIZE = 4;
    public static final int TIMEOUT = 1;

    public static void main(String[] args) throws InterruptedException {
        List<City> cities = Data.getCities();
        List<Monster> monsters = Data.getMonsters();

        ExecutorService executor = Executors.newFixedThreadPool(THREADS_POOL_SIZE);

        for (City city : cities) {
            CityWorker cityWorker = new CityWorker(city, monsters);
            executor.submit(cityWorker);
        }

        executor.shutdown();
        checkTaskComplete(executor);
    }

    private static void checkTaskComplete(ExecutorService executor) {
        try {
            if (executor.awaitTermination(TIMEOUT, TimeUnit.MINUTES)) {
                System.out.println("Все маршруты вычислены");
            } else {
                System.out.println("В отведенное время вычисления не выполнены");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Завершение задач было прервано: " + e.getMessage());
        }
    }

}
