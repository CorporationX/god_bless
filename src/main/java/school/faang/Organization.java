package school.faang;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicReference;

@Slf4j
public class Organization {
    private final AtomicReference<Double> balance = new AtomicReference<>(0.0);

    public void addDonation(Donation donation) {
        balance.accumulateAndGet(donation.amount(), Double::sum);
        log.info("Received donation with id {} and sum {}, Updated balance: {}",
                donation.id(), donation.amount(), balance.get());

    }
}
