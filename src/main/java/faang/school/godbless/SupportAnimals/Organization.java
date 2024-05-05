package faang.school.godbless.SupportAnimals;

import lombok.Getter;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class Organization {
    private final AtomicInteger balance;

    public Organization(int initialBalance) {
        this.balance = new AtomicInteger(initialBalance);
    }

    public void addDonation(Donation donation) {
        balance.addAndGet(donation.getAmount());
    }
}
