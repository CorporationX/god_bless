package faang.school.godbless.animalssup;

import lombok.Getter;

import java.util.concurrent.atomic.AtomicLong;

@Getter
public class Organization {

    private AtomicLong balance = new AtomicLong(0);

    public void addDonation(Donation donation) {
        balance.addAndGet(donation.getAmount());
    }
}
