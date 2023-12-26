package faang.school.godbless.asunch_future;

import java.util.concurrent.*;

public class MasterCardService {
    public static void main(String[] args) {
        doAll();
    }


    public static int collectPayment() {
        try {
            Thread.sleep(10_000);
            System.out.println("Метод collectPayment обрабатывается потоком: " + Thread.currentThread().getName());
            return 10_000;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static int sendAnalytics() {
        try {
            Thread.sleep(1_000);
            System.out.println("Метод sendAnalytics обрабатывается потоком: " + Thread.currentThread().getName());
            return 1_000;
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void doAll() {
        ExecutorService executors = Executors.newFixedThreadPool(2);  // создал свой executor, пробовал и singleThread
        CompletableFuture<Integer> analytics = CompletableFuture.supplyAsync(MasterCardService::sendAnalytics, executors); // асинхронно запускаем поток из созданного пула
        Future<Integer> payments = executors.submit(MasterCardService::collectPayment); // запускаем поток

        try {
            System.out.println("Время обработки аналитики: " + analytics.get() + " " + Thread.currentThread().getName());
            System.out.println("Время обработки платежа: " + payments.get() + " " + Thread.currentThread().getName());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        executors.shutdown();
        System.out.println("Потоки остановлены!");
    }
}