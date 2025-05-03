package school.faang.support_animals;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        Organization organization = new Organization();

        List<Donation> donations = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 50; i++) {
            donations.add(new Donation(i, random.nextDouble(500) + 100));
        }

        ExecutorService service = Executors.newFixedThreadPool(10);
        List<CompletableFuture<Donation>> completableFutureList = new ArrayList<>();
        for (Donation donat : donations) {
            CompletableFuture<Donation> future = CompletableFuture.supplyAsync(() -> {
                organization.addDonation(donat);
                return donat;
            }, service);
            completableFutureList.add(future);
        }

        CompletableFuture<Void> allOf =
                CompletableFuture.allOf(completableFutureList.toArray(new CompletableFuture[0]));
        allOf.join();

        service.shutdown();
        organization.printAll();
        System.out.println(organization.sumDonation());
    }
}
