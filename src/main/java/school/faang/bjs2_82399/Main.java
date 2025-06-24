package school.faang.bjs2_82399;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int NUM_THREADS = 4;
    private static final int TIMEOUT = 10;

    public static void main(String[] args) {
        ExecutorService poolThread = Executors.newFixedThreadPool(NUM_THREADS);

        MasterCardService service = new MasterCardService();
        service.doAll(poolThread);

        poolThread.shutdown();
        try {
            if (!poolThread.awaitTermination(TIMEOUT, TimeUnit.SECONDS)) {
                List<Runnable> tasks = poolThread.shutdownNow();
                log.info("Досрочное завершение задач: {}", tasks.size());
            }
        } catch (InterruptedException e) {
            List<Runnable> tasks = poolThread.shutdownNow();
            log.info("Поток был прерван. Досрочное завершение задач: {}", tasks.size());
        }
    }
}
