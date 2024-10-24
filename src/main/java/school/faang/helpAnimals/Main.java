package school.faang.helpAnimals;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;

public class Main {
    private static final int NUMBER_OF_DONATIONS = 100;
    private static final Random random = new Random();

    public static void main(String[] args) {
        Organization organization = new Organization();
        List<CompletableFuture<Void>> futures = new ArrayList<>();
        for (int i = 0; i < NUMBER_OF_DONATIONS; i++) {
            int copyI = i;
            futures.add(CompletableFuture.runAsync(() -> {
                organization.addDonation(new Donation(copyI, random.nextDouble(10.0, 1000.0)));
                System.out.println("Donation " + copyI + " added. Balance: " + organization.getBalance());
            }));
        }
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .thenRun(() -> System.out.println("All donations have been added. Final balance: " + organization.getBalance()))
                .join();
    }
}
