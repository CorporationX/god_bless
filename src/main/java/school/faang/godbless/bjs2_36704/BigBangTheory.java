package school.faang.godbless.bjs2_36704;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class BigBangTheory {
    private static final int THREADS_NUMBER = 4;

    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(THREADS_NUMBER);
        Task theory = new Task("Sheldon", "Prepare the theory");
        Task modelling = new Task("Leonard", "Model the experiment");
        Task tools = new Task("Howard", "Develop the tools");
        Task data = new Task("Rajesh", "Analyse the data");
        pool.submit(theory);
        pool.submit(modelling);
        pool.submit(tools);
        pool.submit(data);
        pool.shutdown();
        try {
            if (pool.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS)) {
                log.info("Completed all tasks");
            } else {
                log.error("The pool is not terminated");
                throw new IllegalStateException("The pool is not terminated");
            }
        } catch (InterruptedException e) {
            log.warn("Main thread is interrupted");
            Thread.currentThread().interrupt();
        }
    }
}
