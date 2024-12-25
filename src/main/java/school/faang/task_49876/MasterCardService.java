package school.faang.task_49876;

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

    static int sendAnalytics() {
        try {
            Thread.sleep(1_000);
            return 1_000;
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public void doAll() {
        ExecutorService service = Executors.newSingleThreadExecutor();

        CompletableFuture<Integer> resultFutureAnalytic = CompletableFuture.supplyAsync(() -> sendAnalytics());
        Integer resultAnalytics = resultFutureAnalytic.join();
        System.out.println(String.format("Result's of analytic = %d", resultAnalytics));

        Future<Integer> resultFutureCollect = service.submit(() -> collectPayment());
        try {
            Integer resultCollect = resultFutureCollect.get();
            System.out.println(String.format("Result's of collecting payments = %d", resultCollect));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        service.shutdown();
        try {
            service.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
//Запустите метод collectPayment() в отдельном потоке и получите результат через Future.
//Запустите метод sendAnalytics() асинхронно через CompletableFuture.
//Основной поток должен сначала дождаться завершения отправки аналитики и вывести результат.
//После этого основной поток должен дождаться завершения обработки платежа и вывести результат.