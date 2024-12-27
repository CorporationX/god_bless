package school.faang.sprint4.bjs_49890;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Slf4j
public class MasterCardService {
    private static final int PAYMENT_AMOUNT = 10000;
    private static final int ANALYTICS_AMOUNT = 1000;

    public static void main(String[] args) {
        MasterCardService service = new MasterCardService();
        service.doAll();
    }

    public static int collectPayment() {
        try {
            Thread.sleep(PAYMENT_AMOUNT);
            return PAYMENT_AMOUNT;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public static int sendAnalytics() {
        try {
            Thread.sleep(ANALYTICS_AMOUNT);
        } catch (InterruptedException e) {
            log.info("Поток был прерван");
            Thread.currentThread().interrupt();
        }

        return ANALYTICS_AMOUNT;
    }

    @SneakyThrows
    public void doAll() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> payment = executor.submit(MasterCardService::collectPayment);
        CompletableFuture<Integer> analytics = CompletableFuture.supplyAsync(MasterCardService::sendAnalytics);

        Integer analyticsResult = analytics.join();
        log.info("Аналитика отправлена: {}", analyticsResult);

        Integer paymentResult = payment.get();
        log.info("Платеж выполнен: {}", paymentResult);
    }
}
