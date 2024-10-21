package school.faang.asyncFuture;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class MasterCardService {

    public static int collectPayment(Payment payment) {
        try {
            Thread.sleep(10_000);
            return payment.getMoneyAmount();
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public static void sendAnalytics(List<Payment> payments) {
        try {
            Thread.sleep(1_000);
            Map<String, Double> avgMoney = payments.stream()
                    .collect(Collectors.groupingBy(Payment::getType,
                            Collectors.averagingDouble(Payment::getMoneyAmount)));
            System.out.println("Average money amount spent on payments:");
            System.out.println(avgMoney);
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public void doAll() {
        List<Payment> payments = Payment.generatePayments(10);
        List<CompletableFuture<Integer>> collectResults = new ArrayList<>();
        for (Payment payment : payments) {
            collectResults.add(CompletableFuture.supplyAsync(() -> MasterCardService.collectPayment(payment)));
        }

        CompletableFuture.runAsync(() -> MasterCardService.sendAnalytics(payments))
                .thenRun(() -> System.out.println("Analytics is sent."));
        List<Integer> result = collectResults.stream()
                .map(CompletableFuture::join)
                .toList();
        System.out.println(result);
    }
}