package faang.school.godbless.modul4.animals;

import lombok.RequiredArgsConstructor;

import java.util.concurrent.atomic.AtomicLong;

@RequiredArgsConstructor
public class Organization {
    private final AtomicLong balance;

    public void addDonation(Donation donation) {
        balance.getAndAdd(donation.getDonate());
    }

    public long getBalance() {
        return balance.get();
    }
}
