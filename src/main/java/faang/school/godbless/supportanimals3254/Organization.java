package faang.school.godbless.supportanimals3254;

import java.util.concurrent.atomic.AtomicInteger;

public class Organization {
    private AtomicInteger balance;

    public Organization() {
        this.balance = new AtomicInteger(0);
    }

    public void addDonation(Donation donation) {
        this.balance.addAndGet(donation.getAmount());
    }

    public int getBalance() {
        return this.balance.get();
    }
}
