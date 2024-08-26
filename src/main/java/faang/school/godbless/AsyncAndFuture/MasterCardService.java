package faang.school.godbless.AsyncAndFuture;

import java.util.Random;
import java.util.concurrent.*;

public class MasterCardService {

    public int collectPayment() {
        try {
            Thread.sleep(new Random().nextInt(5) * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return new Random().nextInt(10);
    }

    public int sendAnalytics() {
        try {
            Thread.sleep(new Random().nextInt(5) * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return new Random().nextInt(10);
    }

    public void doAll() {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Future<Integer> paymentFuture = executor.submit(this::collectPayment);
        CompletableFuture<Integer> analyticsFuture = CompletableFuture.supplyAsync(this::sendAnalytics, executor);
        int analytics = analyticsFuture.join();
        System.out.println("аналитика " + analytics);
        int payment;

        while (!paymentFuture.isDone()) {
            //если вставить сюда sout, то тогда не будет видно первый вывод
        }

        try {
            payment = paymentFuture.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        System.out.println("payment " + payment);

        executor.shutdown();
        try {
            if (!executor.awaitTermination(1, TimeUnit.HOURS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
