package school.faang.supportanimals;

import java.util.concurrent.atomic.DoubleAdder;

public class Organization {
    private final DoubleAdder totalBalance = new DoubleAdder();

    public void addDonation(Donation donation) {
        totalBalance.add(donation.getAmount());
    }

    public double getTotalBalance() {
        return totalBalance.sum();
    }
}
