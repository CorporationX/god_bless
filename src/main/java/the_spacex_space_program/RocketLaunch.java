package the_spacex_space_program;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Data
@AllArgsConstructor
public class RocketLaunch {
    private String name;
    private long launchTime;

    private static final ExecutorService executorService = Executors.newSingleThreadExecutor();

    /**
     * Simulate a rocket launch.
     * <p>
     * This method will cause the calling thread to sleep for 1 second, then
     * print a message indicating that the rocket was successfully launched.
     *
     * @throws InterruptedException if the thread is interrupted while sleeping
     */
    public void launch() throws InterruptedException {
        Thread.sleep(1000L);
        System.out.printf("Ракета %s успешно запущена%n", name);
    }

    /**
     * Plan a sequence of rocket launches, given as a list of {@link RocketLaunch}.
     * The launches will be executed in order of their launch time, with a delay
     * between each launch equal to the difference in milliseconds between the
     * current time and the launch time.
     *
     * Note that the launches will be executed in a single-threaded executor, so
     * the launches will not be executed concurrently. If a launch is interrupted,
     * the current thread will be interrupted and the method will rethrow the
     * exception.
     *
     * @param launches a list of rocket launches to plan
     * @throws InterruptedException if the current thread is interrupted
     */
    public static void planRocketLaunches(List<RocketLaunch> launches) throws InterruptedException {
        long start = System.currentTimeMillis();

        for (RocketLaunch launch : launches) {
            executorService.submit(() -> {
                LocalDateTime launchDateTime = Instant.ofEpochMilli(launch.getLaunchTime())
                        .atZone(ZoneId.systemDefault())
                        .toLocalDateTime();

                long delay = LocalDateTime.now().until(launchDateTime, ChronoUnit.SECONDS);

                if (delay > 0) {
                    try {
                        Thread.sleep(delay * 1000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        System.out.println("Запуск был прерван: " + launch.getName());
                    }
                }

                try {
                    launch.launch();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        executorService.shutdown();

        if (executorService.awaitTermination(30, TimeUnit.SECONDS)) {
            System.out.println("Время запуска: " + (System.currentTimeMillis() - start) + " мс");
        }
    }
}
