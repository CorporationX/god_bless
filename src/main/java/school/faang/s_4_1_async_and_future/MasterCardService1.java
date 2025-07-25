package school.faang.s_4_1_async_and_future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MasterCardService1 {
    public int collectPayment() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return 1000;
    }

    public String sendAnalytics() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "analytics: 10 02 666";
    }

    public void doAll() {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        Future<Integer> paymentFuture = executor.submit(this::collectPayment);
        Future<String> analyticsFuture = executor.submit(this::sendAnalytics);
//        while (!paymentFuture.isDone() || !analyticsFuture.isDone()) {
//            System.out.println("Still working...");
//            try {
//                Thread.sleep(100); // ждём 100 мс, перед следующей проверкой
//            } catch (InterruptedException e) {
//                Thread.currentThread().interrupt();
//            }
//        }
        try {
            System.out.println("Payment received: " + paymentFuture.get());
            System.out.println("Analytics was sent: " + analyticsFuture.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        } finally {
            executor.shutdown();
        }
    }
}
