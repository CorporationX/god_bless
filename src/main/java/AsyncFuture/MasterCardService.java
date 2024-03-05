package AsyncFuture;

import java.util.concurrent.*;

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

    void doAll() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Integer> result = executorService.submit(MasterCardService::collectPayment);
        CompletableFuture<Integer> result2 = CompletableFuture.supplyAsync(MasterCardService::sendAnalystics);

        try {
            int analyticsResult = result2.get();
            System.out.println(result2);
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            int paymentResult = result.get();
            System.out.println(result);
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        executorService.shutdown();
    }

    public static void main(String[] args) {
        MasterCardService service = new MasterCardService();
        service.doAll();
    }
}

