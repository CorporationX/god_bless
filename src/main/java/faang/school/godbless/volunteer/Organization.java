package faang.school.godbless.volunteer;

import java.util.concurrent.atomic.AtomicInteger;

public class Organization {

    private final AtomicInteger balance = new AtomicInteger(0);

    public void addDonation(Donation donation) {
        balance.addAndGet(donation.sum());
    }

    public void printBalance() {
        System.out.println("Current balance: " + balance);
    }
}
