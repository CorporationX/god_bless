package faang.school.godbless.concurrency.donations;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class Organization {
    private final AtomicInteger balance = new AtomicInteger(0);
    private final Set<Donation> donations = new HashSet<>();

    public void addDonation(@NonNull Donation newDonation) {
        balance.addAndGet(newDonation.donationSum());

        donations.add(newDonation);
        log.info("New donation accepted. " + newDonation);
    }

    public int getCurrentBalance() {
        return balance.get();
    }
}
