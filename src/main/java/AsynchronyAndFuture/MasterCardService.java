package AsynchronyAndFuture;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class MasterCardService {

    public void doAll(ExecutorService executorService) {
        Future<Integer> payment = executorService.submit(() -> collectPayment());
        Future<Integer> analytics = executorService.submit(() -> sendAnalytics());

        int paymentResult = 0;
        int analyticsResult = 0;
        try {
            paymentResult = payment.get();
            analyticsResult = analytics.get();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e.getCause());
        } finally {
            executorService.shutdown();
        }
        System.out.println(paymentResult);
        System.out.println(analyticsResult);
    }

    private int collectPayment() {
        try {
            Thread.sleep(5_000);
            return 10_000;
        } catch (InterruptedException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    private int sendAnalytics() {
        try {
            Thread.sleep(2_500);
            return 5_000;
        } catch (InterruptedException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
