package faang.school.godbless.multithreading.volotileImmutable.supportAnimals;

import lombok.Getter;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class Organization {
    private volatile AtomicInteger generalSum = new AtomicInteger();

    public CompletableFuture<Donation> addDonation(Donation donation) {

        CompletableFuture<Donation> donationFuture = CompletableFuture.supplyAsync(() -> {
            generalSum.addAndGet(donation.getAmountDonation());
            return donation;
        });
        return donationFuture;
    }
}
