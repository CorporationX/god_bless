package school.faang.async.asynchrony.and.future;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@Slf4j
public class MasterCardService {

    public String collectPayment() {
        System.out.println("Происходит оплата...");
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Оплата прошла успешно!");
        return "Данные об оплате";
    }

    public void sendAnalytics() {
        System.out.println("Происходит сбор аналитики...");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Аналитика успешно собрана!");
    }

    public void doAll() {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Future<String> paymentDataFuture = executor.submit(this::collectPayment);
        CompletableFuture<Void> sendAnalyticsFuture = CompletableFuture.runAsync(this::sendAnalytics, executor);
        try {
            sendAnalyticsFuture.get();
            paymentDataFuture.get(1, TimeUnit.MINUTES);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            executor.shutdown();
        }
    }
}
