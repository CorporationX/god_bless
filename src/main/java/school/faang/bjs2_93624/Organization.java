package school.faang.bjs2_93624;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.DoubleAdder;

public class Organization {
    private final DoubleAdder totalBalance = new DoubleAdder();
    private final ConcurrentHashMap<Integer, Donation> donations = new ConcurrentHashMap<>();
    private final AtomicInteger donationCounter = new AtomicInteger(0);

    public void addDonation(Donation donation) {
        totalBalance.add(donation.getAmount());
        donations.put(donation.getId(), donation);
        donationCounter.incrementAndGet();
    }

    public void printAllDonations() {
        System.out.printf("All donations: %n");
        for (Map.Entry<Integer, Donation> donation : donations.entrySet()) {
            System.out.printf("ID: %s, Value: %s%n", donation.getKey(), donation.getValue().getAmount());
        }
    }

    public void getBalance() {
        System.out.printf("Total balance: %s%n", totalBalance.sum());
    }

    public void getDonationCounter() {
        System.out.printf("Donations count: %s%n", donationCounter.get());
    }
}
