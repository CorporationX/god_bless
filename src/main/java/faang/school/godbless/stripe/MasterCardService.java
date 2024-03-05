package faang.school.godbless.stripe;

import java.util.concurrent.*;


public class MasterCardService {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        doAll();
    }

    public static void doAll() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Integer> future1 = executorService.submit(MasterCardService::collectPayment);

        CompletableFuture<Integer> analysticsFuture = CompletableFuture.supplyAsync(MasterCardService::sendAnalystics);
        System.out.println(analysticsFuture.get());
        System.out.println(future1.get());
        executorService.shutdown();
        if(executorService.awaitTermination(1,TimeUnit.MINUTES)){
            System.out.println("Все потоки были завершены успешно");
        }else {
            System.out.println("Не все потоки были завершены за отведенное время");
        }
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

    static int sendAnalystics() {
        try {
            Thread.sleep(1_000);
            return 1_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

}
