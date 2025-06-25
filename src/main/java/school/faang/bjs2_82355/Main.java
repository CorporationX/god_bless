package school.faang.bjs2_82355;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final long POOL_AWAIT_TIMEOUT = 20;
    private static ExecutorService fixedPool = Executors.newFixedThreadPool(2);
    private static MasterCardService masterCardService = new MasterCardService(fixedPool);

    public static void main(String[] args) {
        masterCardService.processPaymentWithAnalytics();

        fixedPool.shutdown();
        try {
            while (!fixedPool.awaitTermination(POOL_AWAIT_TIMEOUT, TimeUnit.SECONDS)) {
                log.info("Не все задачи завершены");
                fixedPool.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Поток был прерван", e);
            fixedPool.shutdownNow();
        }
        log.info("Все задачи завершены");
    }
}
