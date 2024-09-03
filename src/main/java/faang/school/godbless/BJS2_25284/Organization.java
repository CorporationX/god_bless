package faang.school.godbless.BJS2_25284;

import java.util.concurrent.atomic.AtomicInteger;

public class Organization {
    private final AtomicInteger atomicInteger = new AtomicInteger();

    public void addDonation(Donation donation) {
        atomicInteger.addAndGet(donation.donationAmount());
    }

    public int getDonationAmount() {
        return atomicInteger.get();
    }
}
