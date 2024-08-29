package faang.school.godbless.BJS2_25400;

import lombok.Getter;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class Organization {
    private AtomicInteger balance = new AtomicInteger(0);

    public void addDonation(Donation donation) {
        System.out.println("Current balance: " + balance.addAndGet(donation.getAmount()));
    }
}
