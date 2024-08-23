package faang.school.godbless.task.multithreading.space.x;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    private static final int NUMBER_OF_ROCKETS = 5;
    private static final int RANGE_BETWEEN_STARTS = 3000;

    private final static ExecutorService executor = Executors.newSingleThreadExecutor();

    public static void main(String[] args) {
        CompletableFuture<Long> compFuture = CompletableFuture.supplyAsync(() ->
                planRocketLauncher(getRockets()), executor);
        executor.shutdown();
        compFuture
                .thenAccept(time -> log.info("Time of execution: {} milliseconds", time))
                .join();
    }

    private static long planRocketLauncher(List<RocketLauncher> rocket) {
        long start = System.currentTimeMillis();
        rocket
                .forEach(Main::startRocket);
        return System.currentTimeMillis() - start;
    }

    private static void startRocket(RocketLauncher rocket) {
        threadSleep(getMillToStart(rocket));
        rocket.launch();
    }

    private static long getMillToStart(RocketLauncher rocket) {
        return rocket.getTimeOfStart() - System.currentTimeMillis();
    }

    private static void threadSleep(long mill) {
        try {
            Thread.sleep(mill);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static List<RocketLauncher> getRockets() {
        return IntStream
                .rangeClosed(1, NUMBER_OF_ROCKETS)
                .mapToObj(i -> new RocketLauncher("Rocket " + i, getTimeOfStart(i)))
                .toList();
    }

    private static long getTimeOfStart(long i) {
        return System.currentTimeMillis() + (i * RANGE_BETWEEN_STARTS);
    }
}
