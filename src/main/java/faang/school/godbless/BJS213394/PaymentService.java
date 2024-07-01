package faang.school.godbless.BJS213394;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class PaymentService {
    private MasterCardService card = new MasterCardService();
    private ExecutorService executor = Executors.newFixedThreadPool(2);

    public void doAll() {
        Future future = executor.submit(card::collectPayment);
        CompletableFuture completableFuture = CompletableFuture.supplyAsync(card::sendAnalytics);

        completableFuture.thenAccept(result ->
        {
            System.out.println("Проверка проведена!");
            System.out.println("Результат составил: " + result);
        });
    }
}