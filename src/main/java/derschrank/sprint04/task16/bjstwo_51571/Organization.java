package derschrank.sprint04.task16.bjstwo_51571;

import java.util.concurrent.atomic.AtomicInteger;

public class Organization {
    private final AtomicInteger allAmount = new AtomicInteger();

    public void addDonation(Donation donation) {
        System.out.printf("Donations: %d, amount: %d%n", donation.id(), donation.amount());
        allAmount.addAndGet(donation.amount());
    }

    public int getAmount() {
        return allAmount.get();
    }
}
