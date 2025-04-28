package school.faang.donation;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;

@Getter
@EqualsAndHashCode
@ToString
public class Organization {
    private final AtomicReference<Double> balance = new AtomicReference<>(0.0);
    private final ConcurrentHashMap<Integer, Boolean> processedDonations = new ConcurrentHashMap<>();

    public boolean addDonation(Donation donation) {
        if (processedDonations.putIfAbsent(donation.getId(), true) != null) {
            return false;
        }
        balance.updateAndGet(current -> current + donation.getAmount());
        return true;
    }
}
