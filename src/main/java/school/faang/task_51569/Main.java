package school.faang.task_51569;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    private static final int THREAD_POOL_SIZE = 5;
    private static final int AWAIT_TERMINATION_TIME = 60;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        List<Donation> donationList = new ArrayList<>();
        donationList.add(new Donation(1, 1000.5));
        donationList.add(new Donation(2, 8000.5));
        donationList.add(new Donation(3, 500.3));
        donationList.add(new Donation(4, 1500.5));

        Organization organization = new Organization();
        List<CompletableFuture<Void>> futures = donationList.stream()
                .filter(Objects::nonNull)
                .map(donation -> organization.addDonation(donation, executorService))
                .toList();

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .thenRun(() -> System.out.println(organization.getTotalAmount()));

        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(AWAIT_TERMINATION_TIME, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }
}
