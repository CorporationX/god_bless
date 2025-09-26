package school.faang.bjs2_89561;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class BigBangTheory {

    public static void main(String[] args) {

        Task task1 = new Task("Sheldon", "Theory preparation");
        Task task2 = new Task("Leonard", "Experiment modelling");
        Task task3 = new Task("Howard", "Tools development");
        Task task4 = new Task("Rajesh", "Data analysis");

        ExecutorService exec = Executors.newFixedThreadPool(4);

        exec.submit(task1);
        exec.submit(task2);
        exec.submit(task3);
        exec.submit(task4);

        exec.shutdown();
        try {
            if (!exec.awaitTermination(1, TimeUnit.MINUTES)) {
                log.warn("Some tasks chose were not finish in time ...");
                exec.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Task execution was interrupted.");
            exec.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
