package school.faang.task_51568;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Organization {
    private final Map<Integer, Donation> donations = new ConcurrentHashMap<>();
    private final AtomicInteger donationCounter = new AtomicInteger(0);

    public void addDonation(double amount) {
        int newId = donationCounter.getAndIncrement();
        Donation donation = new Donation(newId, amount);
        donations.put(newId, donation);
    }

    public double getBalance() {
        return donations.values().stream()
                .mapToDouble(Donation::amount)
                .sum();
    }
}
