package faang.school.godbless.asyncandfuture;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Slf4j
public class Main {

    private static MasterCardService masterCardService;

    public static void main(String[] args) {
        masterCardService = new MasterCardService();
        try {
            doAll();
        } catch (ExecutionException | InterruptedException e) {
            log.error(e.getMessage());
        }
    }

    public static void doAll() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<Integer> analytic = executorService.submit(() -> masterCardService.sendAnalytics());
        Future<Integer> collectedPayment = executorService.submit(() -> masterCardService.collectPayment());

        executorService.shutdown();

        System.out.println(analytic.get());
        System.out.println(collectedPayment.get());
    }
}
