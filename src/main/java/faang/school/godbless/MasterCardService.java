package faang.school.godbless;

import java.util.concurrent.*;

public class MasterCardService {

    private ExecutorService executor;

    public MasterCardService() {
        executor = Executors.newFixedThreadPool(2);
    }

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

    public void doAll() {
        CompletableFuture<Integer> sendAnalyticsFuture = CompletableFuture.supplyAsync(MasterCardService::sendAnalytics, executor);
        Future<Integer> collectPaymentFuture = executor.submit(MasterCardService::collectPayment);

        sendAnalyticsFuture.thenAccept(result -> {
            System.out.println("sendAnalytics result: " + result);

            try{
                executor.shutdown();
                executor.awaitTermination(20, TimeUnit.SECONDS);
            } catch(InterruptedException e) {
                e.printStackTrace();
                throw new RuntimeException();
            }
        });

        try {
            int collectPaymentResult = collectPaymentFuture.get();
            System.out.println("collectPayment result: " + collectPaymentResult);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        MasterCardService service = new MasterCardService();
        service.doAll();
    }
}
