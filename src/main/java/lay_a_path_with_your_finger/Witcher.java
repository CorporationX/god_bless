package lay_a_path_with_your_finger;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Witcher {
    private static final int COUNT_OF_THREADS = 2;
    private static final int TIME_OF_WORK = 10;
    private static ExecutorService executorService = Executors.newFixedThreadPool(COUNT_OF_THREADS);

    /**
     * Main method of the application.
     * <p>
     * This method creates two instances of {@link CityWorker} and submits them to the executor service.
     * It then waits for the termination of all submitted tasks and prints the total time of execution
     * in milliseconds.
     *
     * @param args The command line arguments of the application.
     * @throws InterruptedException If the current thread is interrupted while waiting for the
     *                               termination of the executor service.
     */
    public static void main(String[] args) throws InterruptedException {
        long startTime = System.currentTimeMillis();

        CityWorker firstCityWorker = new CityWorker(
                new City("Westeros", new Location(10, 30)),
                List.of(
                        new Monster("Dragon", new Location(30, 40)),
                        new Monster("Warg", new Location(20, 35))
                )
        );

        CityWorker secondCityWorker = new CityWorker(
                new City("Lannister", new Location(20, -170)),
                List.of(
                        new Monster("Lion", new Location(30, -150)),
                        new Monster("Troll", new Location(21, -182))
                )
        );

        for (CityWorker cityWorker : List.of(firstCityWorker, secondCityWorker)) {
            executorService.submit(cityWorker);
        }

        executorService.shutdown();

        if (executorService.awaitTermination(TIME_OF_WORK, TimeUnit.SECONDS)) {
            long endTime = System.currentTimeMillis();
            long totalTime = endTime - startTime;

            System.out.printf("Общее время выполнения программы: %d мс", totalTime);
        }
    }
}
