package school.faang.multithreading.concurr.support.animals;

import com.google.common.util.concurrent.AtomicDouble;

public class Organization {
    private final AtomicDouble balance = new AtomicDouble(0.0);

    public void addDonation(Donation donation) {
        balance.addAndGet(donation.getAmount());
    }

    public double getBalance() {
        return balance.get();
    }
}
