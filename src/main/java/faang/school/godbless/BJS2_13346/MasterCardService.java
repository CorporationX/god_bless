package faang.school.godbless.BJS2_13346;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class MasterCardService {

    private static int collectPayment() {
        try {
            System.out.println("we are here");
            Thread.sleep(10_000);
            return 10_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    private static int sendAnalytics() {
        try {
            Thread.sleep(1_000);
            return 1_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public void doAll() {
        ExecutorService service = Executors.newSingleThreadExecutor();
        CompletableFuture.supplyAsync(MasterCardService::sendAnalytics).thenAccept(System.out::println);
        Future<Integer> payments = service.submit(MasterCardService::collectPayment);
        service.shutdown();

        try {
            int result = payments.get();
            System.out.println(result);
        } catch (InterruptedException | ExecutionException e) {
            e.getStackTrace();
        }
        System.out.println("waiting");
    }

    public static void main(String[] args) {
        MasterCardService masterCardService = new MasterCardService();
        masterCardService.doAll();
    }
}
