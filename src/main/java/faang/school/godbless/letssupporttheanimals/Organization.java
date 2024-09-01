package faang.school.godbless.letssupporttheanimals;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicLong;

@Slf4j
public class Organization {
    private final AtomicLong totalBalance = new AtomicLong(0);

    public void addDonation(Donation donation) {
        totalBalance.addAndGet(donation.getAmount());
        log.info("Added donation {}, new total balance: {}", donation, totalBalance.get());
    }

    public long getTotalBalance() {
        return totalBalance.get();
    }
}