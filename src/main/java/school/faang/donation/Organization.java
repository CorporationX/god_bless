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

    public void addDonation(Donation donation) {
        if (processedDonations.putIfAbsent(donation.getId(), true) != null) {
            throw new IllegalStateException("Донат с id=" + donation.getId() + " уже был обработан!");
        }
        balance.updateAndGet(current -> current + donation.getAmount());
    }
}
