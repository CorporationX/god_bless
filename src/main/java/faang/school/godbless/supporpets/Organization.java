package faang.school.godbless.supporpets;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class Organization {

    private final AtomicInteger balance = new AtomicInteger(0);

    public void addDonation(Donation donation) {
        balance.getAndAdd(donation.getAmount());
        log.info("add to balance {}, transaction id {}", donation.getAmount(), donation.getId());
    }

    public void logBalance() {
        log.info("Balance: {}", balance.get());
    }
}
