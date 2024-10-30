package school.faang.java.thread2.asyncfuture;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        doAll();
    }

    public static void doAll() throws ExecutionException, InterruptedException {
        MasterCardService masterCardService = new MasterCardService();

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<Integer> future1 = executorService.submit(masterCardService::collectPayment);
        Future<Integer> future2 = executorService.submit(masterCardService::sendAnalytics);
        System.out.printf("\nResult sendAnalytics : %d", future2.get());
        System.out.printf("\nResult collectPayment : %d", future1.get());

        executorService.shutdown();
    }
}