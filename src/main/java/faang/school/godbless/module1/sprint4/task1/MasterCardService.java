package faang.school.godbless.module1.sprint4.task1;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Slf4j
public class MasterCardService {


    public void doAll() {
        ExecutorService service = Executors.newFixedThreadPool(2);
        Future<Integer> resultOfCollectPayment = service.submit(MasterCardService::collectPayment);
        CompletableFuture<Integer> resultOfSendAnalytics
                = CompletableFuture.supplyAsync(MasterCardService::sendAnalytics, service);
        System.out.println(resultOfSendAnalytics.join());
        try {
            System.out.println(resultOfCollectPayment.get());
        } catch (InterruptedException | ExecutionException e) {
            log.error("Method doAll broken", e);
            throw new RuntimeException(e);
        }
        service.shutdown();
    }

    public static int collectPayment() {
        try {
            Thread.sleep(10_000);
            return 10_000;
        } catch (InterruptedException e) {
            log.error("Method collectPayment is broken", e);
            throw new RuntimeException();
        }
    }

    public static int sendAnalytics() {
        try {
            Thread.sleep(1_000);
            return 1_000;
        } catch (InterruptedException x) {
            log.error("Method collectPayment is broken", x);
            throw new RuntimeException();
        }
    }
}
