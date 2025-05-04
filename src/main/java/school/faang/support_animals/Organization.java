package school.faang.support_animals;

import java.util.concurrent.atomic.AtomicReference;

public class Organization {
    private final AtomicReference<Double> balance = new AtomicReference<>(0.);

    public void addDonation(Donation donation) {
        balance.accumulateAndGet(donation.amount(), Double::sum);
    }

    public AtomicReference<Double> sumDonation() {
        return balance;
    }
}
