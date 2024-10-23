package school.faang.BJS2_38102;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MasterCardService {
    private static final Logger logger = LoggerFactory.getLogger(MasterCardService.class);

    ExecutorService executor = Executors.newSingleThreadExecutor();
    Future<Integer> collectResult = executor.submit(this::collectPayment);
    CompletableFuture<Integer> sendResult = CompletableFuture.supplyAsync(this::sendAnalytics);

    public MasterCardService() {}

    public int collectPayment() {
        logger.info("Начат процесс оплаты");
        try {
            Thread.sleep(10_000);
            logger.info("Оплата усепшно завершина");
            return 10_000;
        } catch (Exception e) {
            logger.error("Возникла ошибка при оплате", e);
            return 0;
        }
    }

    public int sendAnalytics() {
        logger.info("Отправка аналитики началась");
        try {
            Thread.sleep(1_000);
            logger.info("Аналатика отправлена");
            return 1_000;
        } catch (Exception e) {
            logger.error("Возникла ошибка при отправке аналитики", e);
            return 0;
        }
    }

    public void doAll() throws ExecutionException, InterruptedException {
        System.out.println("Аналитика отправлена: " + sendResult.join());
        System.out.println("Платеж выполнен: " + collectResult.get());
        executor.shutdown();
    }
}
