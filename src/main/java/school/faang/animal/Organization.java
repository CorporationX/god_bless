package school.faang.animal;

import java.util.concurrent.atomic.DoubleAdder;

public class Organization {
    private DoubleAdder balance = new DoubleAdder();

    public void addDonation(Donation donation) {
        balance.add(donation.getAmount());
    }

    public double getBalance() {
        return balance.sum();
    }
}
