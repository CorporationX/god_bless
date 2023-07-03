package faang.school.godbless.asyncAndFuture;

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

    static int sendAnalystics() {
        try {
            Thread.sleep(1_000);
            return 1_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public static void doAll(){
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<Integer> payment = executorService.submit(MasterCardService::collectPayment);
        CompletableFuture<Integer> analytics = CompletableFuture.supplyAsync(MasterCardService::sendAnalystics);
        while(!analytics.isDone() || !payment.isDone()){
            System.out.println("Ждем");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            System.out.println(payment.get());
            System.out.println(analytics.get());
        } catch(InterruptedException | ExecutionException e){
            e.printStackTrace();
        }
        executorService.shutdown();
    }

    public static void main(String[] args) {
        doAll();
    }
}
