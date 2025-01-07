package school.faang.task_51574;

import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

@Slf4j
public class Organization {
    private final Set<Donation> donations;

    public Organization() {
        this.donations = new CopyOnWriteArraySet<>();
    }

    public void addDonation(@NonNull Donation donation) {
        boolean added = donations.add(donation);
        if (added) {
            log.info("Donation added: {}", donation);
        } else {
            log.warn("Donation already exists: {}", donation);
        }
    }

    public double getBalance() {
        return donations.stream()
                .mapToDouble(Donation::amount)
                .sum();

    }

}
