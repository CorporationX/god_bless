package school.faang.helpanimal;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
@Slf4j
public class Organization {
    private final AtomicInteger totalSum = new AtomicInteger(0);

    public void addDonation(Donation donation) {
        totalSum.addAndGet(donation.amount());
        log.info("(id : {}) New donation on sum: {}", donation.id(), donation.amount());
    }
}
