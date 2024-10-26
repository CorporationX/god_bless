package school.faangSprint4.t12;

import java.util.concurrent.atomic.AtomicReference;

public class Organization {
    private final AtomicReference<Double> balance;

    public Organization() {
        this.balance = new AtomicReference<>(0.0);
    }

    public void addDonation(Donation donation) {
        balance.updateAndGet(currentBalance -> currentBalance + donation.amount());
    }

    public double getBalance() {
        return balance.get();
    }
}