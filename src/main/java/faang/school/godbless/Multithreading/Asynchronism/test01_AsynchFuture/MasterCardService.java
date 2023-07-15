package faang.school.godbless.Multithreading.Asynchronism.test01_AsynchFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MasterCardService {
    public static void main(String[] args) throws ExecutionException, InterruptedException{
        MasterCardService masterCardService = new MasterCardService();
        masterCardService.doAll();
    }

    public static int collectPayment(){
        try {
            Thread.sleep(10_000);
            return 10_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
    public static int sendAnalytics(){
        try {
            Thread.sleep(1_000);
            return 1_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
    public static void doAll() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Integer> payment = executorService.submit(()-> collectPayment());
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(()->sendAnalytics());
        System.out.println("Analytics " + payment.get()+" Payment "+future.get());
    }
}
