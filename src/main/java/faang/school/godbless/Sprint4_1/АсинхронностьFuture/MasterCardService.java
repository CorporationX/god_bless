package faang.school.godbless.Sprint4_1.АсинхронностьFuture;

import java.util.concurrent.*;

public class MasterCardService {
    public static void main(String[] args) {
        try {
            doAll();
        } catch (ExecutionException | java.lang.InterruptedException | TimeoutException e) {
            throw new RuntimeException(e);
        }
    }
    public static void doAll() throws ExecutionException, InterruptedException, TimeoutException {
        ExecutorService executors = Executors.newFixedThreadPool(2);
        Future future1 = executors.submit(()->collectPayment());
        CompletableFuture future2 = CompletableFuture.supplyAsync(()->sendAnalystics());

        System.out.println("Result from collectPayment - "+future2.get(2000, TimeUnit.MILLISECONDS));
        System.out.println("Result from collectPayment - "+future1.get(11000, TimeUnit.MILLISECONDS));
        executors.shutdown();
        executors.awaitTermination(11000, TimeUnit.MILLISECONDS);
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
