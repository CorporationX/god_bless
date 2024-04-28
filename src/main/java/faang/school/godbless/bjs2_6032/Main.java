package faang.school.godbless.bjs2_6032;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        List<Donation> donates = List.of(new Donation(1, 10000), new Donation(2, 15000), new Donation(3, 20000));

        Organization organization = new Organization();

        List<CompletableFuture<Void>> futures = new ArrayList<>();

        for (Donation donation : donates) {
            futures.add(CompletableFuture.runAsync(() -> organization.addDonation(donation)));
        }

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        executorService.shutdown();

        System.out.println("Total balance: " + organization.getBalance());
    }
}
