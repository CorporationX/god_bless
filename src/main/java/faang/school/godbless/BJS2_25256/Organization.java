package faang.school.godbless.BJS2_25256;

import java.util.concurrent.atomic.AtomicInteger;

public class Organization {
    private final AtomicInteger balance = new AtomicInteger(0);

    public void addDonation(Donation donation) {
        balance.addAndGet(donation.getSum());
    }

    public int getBalance() {
        return balance.get();
    }
}
