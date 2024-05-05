package donation;

import lombok.Getter;

import java.util.concurrent.atomic.AtomicLong;

@Getter
public class Organization {
    private AtomicLong balance = new AtomicLong();

    public void addDonation(Donation donation) {
        if (donation == null) {
            throw new NullPointerException("Donation must be exist");
        }
        balance.addAndGet(donation.getSumOfDonation());
    }
}
