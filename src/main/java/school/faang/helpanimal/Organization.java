package school.faang.helpanimal;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@Getter
public class Organization {
    private final AtomicInteger totalSum = new AtomicInteger(0);

    public void addDonation(Donation donation) {
        totalSum.addAndGet(donation.getAmount());
        log.info("(id : {}) New donation on sum: {}", donation.getId(), donation.getAmount());
    }
}
