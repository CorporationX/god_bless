package school.faang.helpAnimals;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    private static final AtomicInteger donationId = new AtomicInteger(0);
    private static final int NUMBER_OF_DONATIONS = 100;
    private static final Random random = new Random();

    public static void main(String[] args) {
        Organization organization = new Organization();
        List<CompletableFuture<Void>> futures = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_DONATIONS; i++) {
            futures.add(CompletableFuture.runAsync(() -> {
                int id = donationId.getAndIncrement();
                organization.addDonation(new Donation(id, random.nextDouble(10.0, 1000.0)));
                System.out.println("Donation " + id + " added. Balance: " + organization.getBalance());
            }));
        }
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .thenRun(() -> System.out.println("All donations have been added. Final balance: " + organization.getBalance()))
                .join();
    }
}
