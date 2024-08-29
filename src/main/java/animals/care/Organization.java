package animals.care;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class Organization {
    private final AtomicInteger balance = new AtomicInteger(0);

    public void addDonation(@NonNull Donation donation) {
        balance.getAndAdd(donation.getDonationAmount());
        log.info(String.format("Donation of %d$ accepted", donation.getDonationAmount()));
    }

    public int getBalance() {
        return balance.get();
    }
}
