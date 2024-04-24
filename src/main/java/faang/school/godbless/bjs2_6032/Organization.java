package faang.school.godbless.bjs2_6032;

import java.util.concurrent.atomic.AtomicLong;

public class Organization {
    private final AtomicLong balance = new AtomicLong(0L);

    public void addDonation(Donation donation) {
        balance.getAndAdd(donation.getDonate());
    }
    
    public long getBalance() {
        return balance.get();
    }
}
