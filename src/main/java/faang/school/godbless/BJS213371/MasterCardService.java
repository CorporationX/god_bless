package faang.school.godbless.BJS213371;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MasterCardService {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        doAll();
    }

    public static void doAll() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<Integer> futureCollectPayment = executorService.submit(MasterCardService::collectPayment);
        Future<Integer> futureSendAnalytics = executorService.submit(MasterCardService::sendAnalytics);
        System.out.println("Отправил аналитику в сервис сбора платежей: " + futureSendAnalytics.get());
        System.out.println("Платеж произошел: " + futureCollectPayment.get());
        executorService.shutdown();
    }

    private static int collectPayment() {
        try {
            Thread.sleep(10_000);
            return 10_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    private static int sendAnalytics() {
        try {
            Thread.sleep(5_000);
            return 5_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

}
