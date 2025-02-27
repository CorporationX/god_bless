package school.faang.sprint4.bjs2_63071;

import lombok.NonNull;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;

public class Organization {
    private final Set<Integer> donationIds = ConcurrentHashMap.newKeySet();
    private final AtomicReference<Double> balance = new AtomicReference<>(0.0);

    public void addDonation(@NonNull Donation donation) {
        int id = donation.getId();
        if (donationIds.add(id)) {
            double amount = donation.getAmount();
            while (true) {
                Double current = balance.get();
                Double next = current + amount;
                if (balance.compareAndSet(current, next)) {
                    break;
                }
            }
        }
    }

    public double getBalance() {
        return balance.get();
    }
}
