package school.faang.sprint_4.task_49884;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int AWAIT_TIME = 50;
    private static final long AMOUNT_OF_POINTS = 99_999_999_999L;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(
                Runtime.getRuntime().availableProcessors(),
                new DaemonThreadFactory()
        );

        System.out.println(PiCalculator.calculate(AMOUNT_OF_POINTS, executorService));

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(AWAIT_TIME, TimeUnit.MINUTES)) {
                log.info("Awaiting termination");
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.info("Main thread interrupted");
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }

    public static class DaemonThreadFactory implements ThreadFactory {
        private final ThreadFactory defaultFactory = Executors.defaultThreadFactory();

        @Override
        public Thread newThread(Runnable r) {
            Thread thread = defaultFactory.newThread(r);
            thread.setDaemon(true);
            return thread;
        }
    }
}


