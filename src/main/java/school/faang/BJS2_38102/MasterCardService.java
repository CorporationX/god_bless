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

    public MasterCardService() {
    }

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
        ExecutorService paymentExecutor = Executors.newSingleThreadExecutor();
        ExecutorService analyticsExecutor = Executors.newFixedThreadPool(2);

        try {
            CompletableFuture<Integer> analyticsFuture = CompletableFuture.supplyAsync(this::sendAnalytics, analyticsExecutor);
            Future<Integer> paymentFuture = paymentExecutor.submit(this::collectPayment);
            System.out.println("Аналитика отправлена: " + analyticsFuture.join());
            System.out.println("Платеж выполнен: " + paymentFuture.get());
        } catch (Exception e) {
            logger.error("Ошибка при выполнении операций", e);
        } finally {
            paymentExecutor.shutdown();
            analyticsExecutor.shutdown();
        }
    }
}
