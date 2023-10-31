package faang.school.godbless;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MasterCardService {
    static int collectPayment() {
        try {
            Thread.sleep(10_000);
            return 10_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    static int sendAnalytics() {
        try {
            Thread.sleep(1_000);
            return 1_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public void doAll(){
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<Integer> collectResult = executor.submit(MasterCardService::collectPayment);
        CompletableFuture<Integer> sendAnalyticResult = CompletableFuture.supplyAsync(MasterCardService::sendAnalytics);

        try{
            System.out.println(collectResult.get());
            System.out.println(sendAnalyticResult.get());
            executor.shutdown();
        } catch (ExecutionException | InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MasterCardService masterCardService = new MasterCardService();
        masterCardService.doAll();
    }
}
