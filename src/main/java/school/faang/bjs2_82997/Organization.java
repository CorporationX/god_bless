package school.faang.bjs2_82997;

import java.util.concurrent.atomic.DoubleAdder;

public class Organization {

    private final DoubleAdder balance = new DoubleAdder();

    public void addDonation(Donation donation) {
        balance.add(donation.getAmount());
    }

    public double getBalance() {
        return balance.sum();
    }
}
