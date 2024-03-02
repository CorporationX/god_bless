package faang.school.godbless.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MasterCardService {
    public static void main(String[] args) {
        MasterCardService masterCardService = new MasterCardService();
        try {
            masterCardService.doAll();
        } catch (ExecutionException | InterruptedException ex) {
            throw new RuntimeException( ex.getMessage() );
        }
    }

    public int collectPayment() {
        try {
            Thread.sleep( 10_000 );
            return 10_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public int sendAnalytics() {
        try {
            Thread.sleep( 1_000 );
            return 1_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public void doAll() throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Integer> paymentResult = executorService.submit( this::collectPayment );
        CompletableFuture<Integer> analyticsResult = CompletableFuture.supplyAsync( this::sendAnalytics );

        System.out.println( analyticsResult.get() );
        System.out.println( paymentResult.get() );

        executorService.shutdown();
    }
}
