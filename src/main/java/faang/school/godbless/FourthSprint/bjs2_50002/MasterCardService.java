package faang.school.godbless.FourthSprint.bjs2_50002;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.*;

public class MasterCardService {
    final static Logger logger = LoggerFactory.getLogger(MasterCardService.class.getName());

    static int collectPayment() {
        try {
            Thread.sleep(1_000);
            return 10_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    static int sendAnalytics() {
        try {
            Thread.sleep(100);
            return 1_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public static void main(String[] args) {
        MasterCardService service = new MasterCardService();
        try {
            service.doAll();
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void doAll() throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Future<Integer> collect = executor.submit(() -> collectPayment());
        CompletableFuture<Integer> sendAnalytic = CompletableFuture.supplyAsync(() -> sendAnalytics());

        Integer completableResult = sendAnalytic.join();
        Integer futureResult = collect.get();

        logger.info("Аналитика отправлена: " + completableResult);
        logger.info("Платеж выполнен: " + futureResult);

        executor.shutdown();
    }
}
