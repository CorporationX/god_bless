package school.faang.animals;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        Organization organization = new Organization();
        List<CompletableFuture<Void>> futures = new ArrayList<>();
        double allDotation = 0.0;

        for (int i = 0; i < 10_000_000; i++) {
            double dotation = ThreadLocalRandom.current().nextDouble(1);
            allDotation += dotation;
            futures.add(CompletableFuture.runAsync(() -> organization.addDonation(dotation)));
        }

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        System.out.println("Всего было пожертований: " + allDotation);
        System.out.println("Баланс организации:  " + organization.getBalance());
    }
}