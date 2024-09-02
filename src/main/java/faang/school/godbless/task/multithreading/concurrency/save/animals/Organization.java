package faang.school.godbless.task.multithreading.concurrency.save.animals;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicLong;

@Slf4j
@Getter
public class Organization {
    private final AtomicLong balance = new AtomicLong();

    public void addDonation(Donation donation) {
        log.info("Add new donation {}", donation);
        balance.addAndGet(donation.donationAmount());
    }
}
