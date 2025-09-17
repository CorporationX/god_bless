package school.faang.bjs2_91285;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class ThreeLittlePigs {
    public static final int THREAD_POOL_SIZE = 3;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        PigThread pig1Thread = new Pig1Thread();
        PigThread pig2Thread = new Pig2Thread();
        PigThread pig3Thread = new Pig3Thread();
        executorService.submit(pig1Thread);
        executorService.submit(pig2Thread);
        executorService.submit(pig3Thread);

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(5, TimeUnit.MINUTES)) {
                executorService.shutdown();
                log.info("The waiting time for all thread has ended");
            }
        } catch (InterruptedException e) {
            log.error("Waiting was interrupted - Forced termination", e);
        }
    }
}
