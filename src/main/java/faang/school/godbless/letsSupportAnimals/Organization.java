package faang.school.godbless.letsSupportAnimals;

import lombok.Getter;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class Organization {
    private AtomicInteger totalBalance;

    public Organization() {
        totalBalance = new AtomicInteger(0);
    }

    public void addDonation(Donation donation) {
        totalBalance.addAndGet(donation.getAmount());
    }
}
