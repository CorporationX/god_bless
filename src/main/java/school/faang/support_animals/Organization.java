package school.faang.support_animals;

import java.util.concurrent.atomic.AtomicReference;

public class Organization {
    private final AtomicReference<Double> balance = new AtomicReference<>(0.0);

    public void addDonation(Donation donation) {
        balance.updateAndGet(current -> current + donation.amount());
    }

    public double sumDonation() {
        return balance.get();
    }

    public void printAll() {
        System.out.println(balance.get());
    }
}