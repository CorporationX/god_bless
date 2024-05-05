package faang.school.godbless.animals;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    private static final int AMOUNT_THREADS = 6;

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(AMOUNT_THREADS);
        final Organization corporationX = new Organization();
        List<CompletableFuture<Void>> futures = new ArrayList<>();

        for (int i = 0; i < AMOUNT_THREADS; i++) {
            futures.add(CompletableFuture.runAsync(() -> {
                for (int g = 1; g < 4; g++) {
                    corporationX.addDonation(new Donation(g, 2));
                }
            }, executor));
        }

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
        executor.shutdown();

        System.out.println(corporationX.getBalance().get());
    }
}
