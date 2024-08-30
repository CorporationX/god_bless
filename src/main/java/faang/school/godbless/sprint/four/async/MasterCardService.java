package faang.school.godbless.sprint.four.async;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MasterCardService {

    public static void main(String... args) {
        doAll();
    }

    private static void doAll() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Integer> payment = executorService.submit(MasterCardService::collectPayment);
        CompletableFuture<Integer> analytics = CompletableFuture.supplyAsync(MasterCardService::sendAnalystics);

        executorService.shutdown();

        while(!payment.isDone() ) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("do some other tasks");
        }

        try {
            System.out.printf("The payment job executes %d milisec%n", payment.get());
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }

        analytics.thenAccept(time -> System.out.printf("The analytics job executes %d milisec%n", time)).join();
        System.out.println("Finish");
    }

    private static int collectPayment() {
        try {
            Thread.sleep(3_000);
            return 3_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

   private static int sendAnalystics() {
        try {
            Thread.sleep(7_000);
            return 7_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
