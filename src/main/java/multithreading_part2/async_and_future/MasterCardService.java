package multithreading_part2.async_and_future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MasterCardService {
    static int collectPayment(){
        try{
            Thread.sleep(10000);
            return 10000;
        }catch(InterruptedException e){
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    static int sendAnalytics(){
        try{
            Thread.sleep(1000);
            return 1000;
        }catch(InterruptedException e){
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
    static void doAll() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future<Integer> futurePayment = executorService.submit(() -> MasterCardService.collectPayment());
        CompletableFuture<Integer> analyticsCompletableFuture = CompletableFuture.supplyAsync(() -> MasterCardService.collectPayment());
        Integer completableFuture = analyticsCompletableFuture.get();
        Integer future = futurePayment.get();
        System.out.println(completableFuture);
        System.out.println(future);
        executorService.shutdown();


    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println("start");
        doAll();
        System.out.println("end");
    }
}
