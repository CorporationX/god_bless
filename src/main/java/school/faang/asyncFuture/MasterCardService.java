package school.faang.asyncFuture;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@Slf4j
public class MasterCardService {
    final int THREAD_AMOUNT = 2;
    private ExecutorService executor = Executors.newFixedThreadPool(THREAD_AMOUNT);

    static int collectPayment(){
        try {
            Thread.sleep(10_000);
            return 10_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            log.error("Сбор оплаты не выполнен.");
            throw new RuntimeException();
        }
    }

    static int sendAnalytics(){
        try {
            Thread.sleep(1_000);
            return 1_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            log.error("Отправка аналитики не выполнена.");
            throw new RuntimeException();
        }
    }

    public void doAll() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> analyticsFuture =
                CompletableFuture.supplyAsync(MasterCardService::sendAnalytics, executor);
        Future<Integer> paymentFuture = executor.submit(MasterCardService::collectPayment);

        Integer analyticsResult = analyticsFuture.join();
        Integer paymentResult = paymentFuture.get();

        System.out.println("Аналитика отправлена: " + analyticsResult);
        System.out.println("Платёж выполнен: " + paymentResult);

        executor.shutdown();
        executor.awaitTermination(30, TimeUnit.SECONDS);
    }
}
