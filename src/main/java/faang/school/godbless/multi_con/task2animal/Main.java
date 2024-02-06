package faang.school.godbless.multi_con.task2animal;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(8);
        Organization organization = new Organization();
        List<CompletableFuture<Void>> allDonates = new ArrayList<>();

        for (int i = 0; i < 10000000; i++) {
            int finalI = i;
            CompletableFuture<Void> run = CompletableFuture.runAsync(() -> {
                organization.addDonation(new Donation(finalI, 1));
            });
            allDonates.add(run);
        }

        CompletableFuture.allOf(allDonates.toArray(new CompletableFuture[0]))
                .thenRun(() -> System.out.println("Баланс организации: " + organization.getBalance()))
                .join();
    }
}
