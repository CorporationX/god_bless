package school.faang.animals;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class Main {
    private static final int THREAD_NUM = 3;
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_NUM);
        Organization organization = new Organization();

        List<CompletableFuture<Void>> addDonationsFutures = new ArrayList<>();
        addDonationsFutures.add(CompletableFuture.runAsync(() ->
                organization.addDonation(new Donation(1, 10.0)), executor));
        addDonationsFutures.add(CompletableFuture.runAsync(() ->
                organization.addDonation(new Donation(1, 15.0)), executor));
        addDonationsFutures.add(CompletableFuture.runAsync(() ->
                organization.addDonation(new Donation(1, 10.0)), executor));
        addDonationsFutures.add(CompletableFuture.runAsync(() ->
                organization.addDonation(new Donation(1, 20.0)), executor));

        try {
            CompletableFuture.allOf(addDonationsFutures.toArray(new CompletableFuture[0])).join();
        } catch (Exception e) {
            log.error("Thread interrupted", e);
        }
        log.info("Donations have been added, current amount {}", organization.getDonations());
        executor.shutdown();
    }
}
