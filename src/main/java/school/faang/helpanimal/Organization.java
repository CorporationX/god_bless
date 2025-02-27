package school.faang.helpanimal;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public record Organization(AtomicInteger totalSum) {
    public Organization() {
        this(new AtomicInteger());
    }

    public void addDonation(Donation donation) {
        totalSum.addAndGet(donation.amount());
        log.info("(id : {}) New donation on sum: {}", donation.id(), donation.amount());
    }
}
