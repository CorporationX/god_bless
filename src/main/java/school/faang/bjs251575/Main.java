package school.faang.bjs251575;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        final long start = System.currentTimeMillis();
        System.out.println("main started");

        Organization organization = new Organization();
        List<Donation> donations = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            donations.add(new Donation(i, i));
        }

        ExecutorService executor = Executors.newFixedThreadPool(donations.size());

        List<CompletableFuture<Void>> futures = new ArrayList<>();
        donations.forEach(donation ->
                futures.add(CompletableFuture.runAsync(() ->
                        organization.addDonation(donation.getAmount()), executor)));

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
        executor.shutdown();

        System.out.println("Total amount from donation: " + organization.getBalance());
        System.out.println("main ended");
        long end = System.currentTimeMillis();
        System.out.println("time elapsed: " + (end - start));
    }

}
