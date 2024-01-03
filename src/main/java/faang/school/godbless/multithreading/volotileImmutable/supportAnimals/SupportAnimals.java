package faang.school.godbless.multithreading.volotileImmutable.supportAnimals;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SupportAnimals {
    public static void main(String[] args) {
        Organization organization = new Organization();
        ExecutorService executorService = Executors.newCachedThreadPool();

        List<CompletableFuture<?>> futures = new ArrayList<>();

        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            final int identifier = i;
            CompletableFuture<Donation> completableFuture = CompletableFuture.supplyAsync(() -> {
                Donation donation = new Donation(identifier, 1_000 + random.nextInt(10_000));
                System.out.println("Added donate - " + donation.getAmountDonation() + " $");
                organization.addDonation(donation);
                return null;
            }, executorService);
            futures.add(completableFuture);
        }

        CompletableFuture<Void> allFutures = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
        allFutures.join();
        executorService.shutdown();
        System.out.println("All donations accepted. General sum is - " + organization.getGeneralSum() + " $");

    }
}
