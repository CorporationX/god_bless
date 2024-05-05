package faang.school.godbless.animals;

import lombok.Getter;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class Organization {
    private final AtomicInteger balance = new AtomicInteger();

    public void addDonation(Donation donation) {
        balance.addAndGet(donation.getAmount());
    }
}
