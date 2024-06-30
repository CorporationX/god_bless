package faang.school.godbless.support_animals;

import lombok.Getter;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class Organization {
    private final AtomicInteger totalAmount = new AtomicInteger();

    public void addDonation(Donation donation) {
        totalAmount.addAndGet(donation.getAmount());
    }
}
