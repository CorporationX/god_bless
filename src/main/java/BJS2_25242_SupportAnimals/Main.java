package BJS2_25242_SupportAnimals;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class Main {
    public static void main(String[] args) throws InterruptedException {
        Organization organization = new Organization();

        List<CompletableFuture<Void>> futures = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            int j = i;
            CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
                Donation donation = new Donation(j, (int) (Math.random() * 100) + 1);
                organization.addDonation(donation.getDonation());
                log.info("New donation number {} and sum donated: {}", donation.getId(), donation.getDonation());
            });
            futures.add(future);
        }

        CompletableFuture<Void> futuresResult = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .thenRun(() -> log.info("Total balance now is : {}", organization.getBalance().get()));
        futuresResult.join();
    }
}
