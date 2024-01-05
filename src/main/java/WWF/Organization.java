package WWF;

import lombok.Getter;

import java.util.concurrent.atomic.AtomicInteger;

@Getter
public class Organization {
    private AtomicInteger balance = new AtomicInteger(0);

    public void addDonation(Donation donation) {
        balance.addAndGet(donation.getVolume());
    }
}
