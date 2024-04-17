package faang.school.godbless.parallelism.binBangTheory;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


@Slf4j
public class BigBangTheory {
    public static final int N_THREADS = 4;

    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(N_THREADS);

        var sheldonTask = new Task("Sheldon", "theory preparation");
        var leonardTask = new Task("Leonard", "simulation of experiment");
        var howardTask = new Task("Howard", "tool development");
        var radjeshTask = new Task("Radjesh", "data analysis");

        log.info("Task execution begins.");

        threadPool.submit(sheldonTask);
        threadPool.submit(leonardTask);
        threadPool.submit(howardTask);
        threadPool.submit(radjeshTask);

        threadPool.shutdown();

        try {
            threadPool.awaitTermination(16, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            log.error("Waiting termination of thread pool tasks was interrupted.", e);
            return;
        }

        log.info("All tasks was successfully accomplished.");
    }
}
