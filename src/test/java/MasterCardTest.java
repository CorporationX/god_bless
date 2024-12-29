import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import school.faang.bjs249921.MasterCardService;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class MasterCardTest {
    MasterCardService masterCardService = new MasterCardService();

    @Test
    public void testCorrectCollectPayment() {
        int result = masterCardService.collectPayment();

        Assertions.assertEquals(10000, result);
    }

    @Test
    public void testCorrectValueAnalyticsSend() {
        int result = masterCardService.sendAnalytics();

        Assertions.assertEquals(1000, result);
    }

    @Test
    public void testCollectPaymentHandlesInterruptedException() {
        Thread.currentThread().interrupt();
        MasterCardService.collectPayment();

        Assertions.assertFalse(Thread.currentThread().isInterrupted());
    }

    @Test
    public void testCorrectTimeDoAll() {
        long startTime = System.currentTimeMillis();
        masterCardService.doAll();
        long finishTime = System.currentTimeMillis();
        Assertions.assertTrue((finishTime - startTime) <= 11000);

    }

    @Test
    public void testConcurrentExecution() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<Integer> future1 = executorService.submit(MasterCardService::collectPayment);
        CompletableFuture<Integer> future2 =
                CompletableFuture.supplyAsync(MasterCardService::sendAnalytics, executorService);

        Assertions.assertEquals(10000, future1.get());
        Assertions.assertEquals(1000, future2.get());

        executorService.shutdown();
        executorService.awaitTermination(20, TimeUnit.SECONDS);
    }
}
