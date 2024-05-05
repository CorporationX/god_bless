package faang.school.godbless.BJS2_6221;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        Organization organization = new Organization("Green peace");
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        List<CompletableFuture<Void>> futures = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            int finalI = i;
            futures.add(CompletableFuture.runAsync(
                    () -> organization.addBalance(new Donation(finalI, finalI * 1000)), executorService));
        }

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
        executorService.shutdown();
        System.out.println(organization.getGeneralBalance().get());

    }
}
