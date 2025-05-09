package school.faang.support;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.DoubleAdder;

public class Organization {
    private final DoubleAdder totalBalance = new DoubleAdder();
    private final ConcurrentHashMap<Integer, Boolean> donationRegistry = new ConcurrentHashMap<>();

    public void addDonation(Donation donation) {
        if (donationRegistry.putIfAbsent(donation.getId(), true) == null) {
            totalBalance.add(donation.getAmount());
        }
    }

    public double getTotalBalance() {
        return totalBalance.sum();
    }
}
