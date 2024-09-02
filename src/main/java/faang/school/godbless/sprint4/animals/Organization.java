package faang.school.godbless.sprint4.animals;

import lombok.Getter;

import java.util.concurrent.atomic.AtomicLong;

@Getter
public class Organization {
    private final AtomicLong balance = new AtomicLong();

    public void addDonation(Donation donation) {
        balance.addAndGet(donation.getValue());
    }
}
