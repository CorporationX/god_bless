package faang.school.godbless.asyncAndFuture.asyncAndFuture;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Getter
@AllArgsConstructor
public class MasterCardService {
    private final int NUMBER_THREAD = 4;

    private ExecutorService executorService;

    public MasterCardService() {
        this.executorService = Executors.newFixedThreadPool(NUMBER_THREAD);
    }

    public int collectPayment() {
        System.out.println("Collect payment...");
        try {
            Thread.sleep(10_000);
            return 10_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public int sendAnalytics() {
        System.out.println("Send analytics...");
        try {
            Thread.sleep(1_000);
            return 1_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public void doAll() throws ExecutionException, InterruptedException, TimeoutException {
        Future<Integer> futureResultOfCollect = executorService.submit(this::collectPayment);
        CompletableFuture<Integer> futureResultOfAnalytics = CompletableFuture.supplyAsync(this::sendAnalytics, executorService);

        futureResultOfAnalytics.thenAccept((result) -> System.out.println("Result of analytics: " + result)).join();
        int resultOfCollect = futureResultOfCollect.get(1, TimeUnit.MINUTES);
        System.out.println("Result of collect: " + resultOfCollect);
        executorService.shutdown();
    }

    public static void main(String[] args) {
        MasterCardService masterCardService = new MasterCardService();
        try {
            masterCardService.doAll();
        } catch (ExecutionException | InterruptedException | TimeoutException e) {
            throw new RuntimeException(e);
        }
    }
}
