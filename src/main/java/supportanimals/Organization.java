package supportanimals;

import java.util.concurrent.atomic.AtomicInteger;

public class Organization {
    private AtomicInteger balance = new AtomicInteger();

    public void addDonation(Donation donation) {
        balance.addAndGet((int) donation.getAmount());
    }

    public int getBalance() {
        return balance.get();
    }
}
